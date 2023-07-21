package entidades;

import audio.AudioPlayer;
import main.Juego;
import utilidades.Animaciones;
import utilidades.AudioURL;
import utilidades.ImagenURL;

import static main.Juego.ALTO_VENTANA;
import static utilidades.Archivos.*;
import static utilidades.Ayuda.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Jugador extends Entidad {

    private BufferedImage imagenes;
    private BufferedImage[][] animaciones;
    private int tick, indice, framesEntreAnimaciones = 12; // 120 FPS y 10 animaciones por segundo
    private Animaciones.Jugador accionAnterior = Animaciones.Jugador.QUIETO;
    private Animaciones.Jugador accionActual = Animaciones.Jugador.QUIETO;
    private boolean moviendose = false;
    private int corriendo = 0;

    // Variable que indica en que direccion mira el personaje
    // true si ve a la derecha y false si ve a la izquierda
    private boolean direccionMirada = true;
    private boolean izquierda, derecha;
    private float velocidad;
    private float velocidadCorriendo = 3.5f;
    private float velocidadCaminando = 2.5f;
    private float aceleracion = 0.1f;
    // Atributo que le pasa la informacion del nivel al jugador para que pueda moverse por el con la hitbox
    private int[][] infoNivel;

    // Variables para el salto y movimiento aereo
    private float velocidadAire = 0f;
    private float gravedad = 0.1f;
    private float velocidadSalto = -4.5f;
    private float velocidadCaida = 0.5f;
    private boolean enAire = false, saltar = false, saltado = false;

    private float diferenciaHitboxX = 6, diferenciaHitboxY = 9;
    private float alturaHitbox = 55, anchuraHitbox = 25;

    //Variables para muerte y powerups
    private int vidas = 3, inicX, inicY;
    private int puntos = 0;
    public final static int NORMAL = 0, FLOR = 1;
    private int power = NORMAL;
    public static final int maxFuego = 2;
    private Fuego[] listaFuego = new Fuego[maxFuego];

    //Frames de invencibilidad
    private int invenTime = 120 * 3, currTime = 0;
    private boolean invencible = false;

    private Juego juego;

    public Jugador(float x, float y, int anchura, int altura, ImagenURL imagenURL, Juego juego) {
        super(x, y, anchura, altura);
        this.juego = juego;
        cargarAnimaciones(imagenURL);
        inicializarHitbox(x, y, anchuraHitbox, alturaHitbox);
        inicX = (int)x;
        inicY = (int)y;
        for(int i = 0; i<listaFuego.length; i++){
            listaFuego[i] = new Fuego(-10, -10);
        }

    }

    public void cargarInfoNivel(int[][] infoNivel) {
        this.infoNivel = infoNivel;
    }

    public void update() {
        setPosicion();
        cambiarAccion();
        actualizarAnimacion();
        dispararFuego();
        invenUpdate();
        for(Fuego f: listaFuego){
            f.update(infoNivel);
        }
    }

    public void render(Graphics g, int lvlOffset) {
//        mostrarHitbox(g);
        float x = hitbox.x - diferenciaHitboxX;
        float y = hitbox.y - diferenciaHitboxY;

        if(!invencible || ((int)(currTime/10))%2 == 0) {
            if (!direccionMirada)
                g.drawImage(animaciones[(power * 8) + accionActual.getPosicion()][indice], (int) (x + anchura) - lvlOffset, (int) y, -anchura, altura, null);
            else
                g.drawImage(animaciones[(power * 8) + accionActual.getPosicion()][indice], (int) x - lvlOffset, (int) y, anchura, altura, null);
        }
        for(Fuego f: listaFuego){
            f.dibujar(g, lvlOffset);
        }
    }

    private void setPosicion() {
        moviendose = false;

        // Hace que el jugador muera cuando se cae del escenario
        if (hitbox.y > ALTO_VENTANA + altura) {
            respawn();
        }


        if (saltar && !saltado) {
            juego.getAudioPlayer().iniciarEfecto(AudioURL.EFECTO_SALTO.getID());
            saltar();
        }

        float xVelocidad = 0;

        // Esto es para que el jugador no se pueda mover si presiona derecha e izquierda a la vez
        if (izquierda) {
            if (velocidad > -(corriendo>0 ? velocidadCorriendo : velocidadCaminando))
                velocidad -= aceleracion;
            if (!sePuedeMover(hitbox.x + velocidad, hitbox.y, hitbox.width, hitbox.height, infoNivel))
                velocidad = 0;
            xVelocidad = velocidad;
            direccionMirada = false;
        }
        if (derecha) {
            if (velocidad < (corriendo>0 ? velocidadCorriendo : velocidadCaminando))
                velocidad += aceleracion;
            if (!sePuedeMover(hitbox.x + velocidad, hitbox.y, hitbox.width, hitbox.height, infoNivel))
                velocidad = 0;
            xVelocidad = velocidad;
            direccionMirada = true;
        }

        if((!izquierda && !derecha) || (izquierda && derecha)){
            if(velocidad > 0)
                velocidad -= aceleracion;
            else if(velocidad < 0)
                velocidad += aceleracion;
            if(velocidad > -aceleracion  && velocidad < aceleracion)
                velocidad = 0;
            xVelocidad = velocidad;
        }

        if (!enAire) {
            if (!enSuelo(hitbox, infoNivel))
                enAire = true;
        }

        if (enAire) {
            if (sePuedeMover(hitbox.x, hitbox.y + velocidadAire, hitbox.width, hitbox.height, infoNivel)){
                hitbox.y += velocidadAire;
                velocidadAire += gravedad;
            } else {
                if (velocidadAire > 0)
                    detenerEnAire();
                else
                    velocidadAire = velocidadCaida;
            }

        }
        actualizarPosicionX(xVelocidad);

        if((izquierda || derecha ) && !(izquierda && derecha))
            moviendose = true;
    }

    private void saltar() {
        if (enAire)
            return;
        enAire = true;
        velocidadAire = velocidadSalto;
        saltado = true;
    }

    private void detenerEnAire() {
        enAire = false;
        velocidadAire = 0;
    }

    private void actualizarPosicionX(float xVelocidad) {
        if (sePuedeMover(hitbox.x + xVelocidad, hitbox.y, hitbox.width, hitbox.height, infoNivel)) {
            hitbox.x += xVelocidad;
        }
    }

    private void dispararFuego(){
        if(corriendo > 1 && power == FLOR){
            corriendo--;
            for(Fuego f: listaFuego){
                if(f.activo == false){
                    f.spawn(hitbox.x+(anchura/2), hitbox.y+(altura/2), !direccionMirada);
                    juego.getAudioPlayer().iniciarEfecto(AudioURL.EFECTO_BOLA_FUEGO.getID());
                    return;
                }
            }
        }
    }

    private void invenUpdate(){
        if(invencible){
            currTime++;
            if(currTime >= invenTime){
                currTime = 0;
                invencible = false;
            }
        }
    }

    private void cargarAnimaciones(ImagenURL imagenURL) {
        imagenes = cargarImagen(imagenURL);

        // Son 14 animaciones en total y la que tiene mas frames tiene 4
        animaciones = new BufferedImage[16][4];

        for (int j = 0; j < 16; j++) {
            for (int i = 0; i < 4; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * 20, j * 30, 20, 30);
            }
        }
    }

    private void cambiarAccion() {
        if (moviendose && corriendo>0 && !enAire)
            accionActual = Animaciones.Jugador.CORRIENDO;
        else if (moviendose && !(corriendo>0) && !enAire)
            accionActual = Animaciones.Jugador.CAMINANDO;
        else
            accionActual = Animaciones.Jugador.QUIETO;

        if (enAire && !(corriendo>0))
            accionActual = Animaciones.Jugador.SALTANDO;
        else if (enAire && corriendo>0)
            accionActual = Animaciones.Jugador.SALTANDO_CORRIENDO;
    }

    public void actualizarAnimacion() {

        // Si la accion actual es diferente a la accion anterior, se reinicia el indice
        // Esto para evitar parpadeos en el cambio de animaciones
        if (accionActual != accionAnterior) {
            indice = 0;
            accionAnterior = accionActual;
        }

        tick++;

        if (tick >= framesEntreAnimaciones) {
            tick = 0;
            indice++;
            if (indice >= accionActual.getCantidadDeFrames()) {
                indice = 0;
            }
        }
    }

    // Se activa en el caso de que el juego se detenga para evitar errores
    public void resetDirecciones() {
        izquierda = derecha = false;
        corriendo = 0;
    }

    //Cuando choca con un emenigo
    public void golpeado(Enemigo enem){
        if(!invencible){
            if(enem.getHitbox().intersects(hitbox) && enem.getEstado() != Enemigo.MORIR && enem.getEstado() != Enemigo.CAPARAZON){
                if(power == NORMAL){
                    respawn();
                }else{
                    invencible = true;
                    power = NORMAL;
                }
            }else if(enem.getHitbox().intersects(hitbox) && enem.getEstado() == Enemigo.CAPARAZON){
                enem.setEstado(Enemigo.MORIR);
            }
        }
    }
    //Cuando pisa con un emenigo
    public void pisar(Enemigo enem){
        if(enem.getPisadoBox().intersects(hitbox) && enem.getEstado() != Enemigo.MORIR){
            juego.getAudioPlayer().iniciarEfecto(AudioURL.EFECTO_PISAR.getID());
            enAire = false;
            saltar();
            enem.setEstado(Enemigo.MORIR);
        }
    }
    //Cuando una bola de fuego toca un enemigo
    public void quemar(Enemigo enem){
        for(Fuego f: listaFuego){
            if(enem.getHitbox().intersects(f.hitbox) && enem.getEstado() != Enemigo.MORIR && enem.getEstado() != Enemigo.CAPARAZON){
                enem.setEstado(Enemigo.MORIR);
                f.respawn();
            }
        }
    }
    //Cuando toca un bloque
    public void bloque(CajaMisterio caja){
        if(caja.getHitbox().intersects(hitbox) && caja.getEstado() != CajaMisterio.NOACTIVO){
            juego.getAudioPlayer().iniciarEfecto(AudioURL.EFECTO_POWER_UP_APARECE.getID());
            caja.desactivar();
        }
    }
    //Cuando toca un powerUp
    public void powerUp(Objeto obj){
        if(obj.getHitbox().intersects(hitbox) && obj.tipo == 3){
            this.vidas++;
            obj.respawn();
        }else if(obj.getHitbox().intersects(hitbox) && obj.tipo == 1){
            juego.getAudioPlayer().iniciarEfecto(AudioURL.EFECTO_POWER_UP.getID());
            this.power = FLOR;
            obj.respawn();
            if(corriendo > 0){
                corriendo = 1;
            }

        }
    }

    public void moneda(Moneda m){
        if(m.getHitbox().intersects(hitbox) && m.activo){
            juego.getAudioPlayer().iniciarEfecto(AudioURL.EFECTO_AGARRAR_MONEDA.getID());
            puntos++;
            m.activo = false;
            if(puntos >= 100){
                puntos = 0;
                vidas++;
            }
        }
    }

    //Cuando pegan, vuelves al principio y pierdes vida
    public void respawn(){
        vidas--;
        hitbox.x = inicX;
        hitbox.y = inicY;
        power = NORMAL;
        if(vidas <= 0){
            System.out.println("Muelto");
        }
    }

    public void setCorriendo(int corriendo) {
        this.corriendo = corriendo;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    public void setSaltar(boolean saltar) {
        this.saltar = saltar;
    }

    public void setSaltado(boolean saltado){
        this.saltado = saltado;
    }

    public boolean isEnAire() {
        return enAire;
    }
 }
