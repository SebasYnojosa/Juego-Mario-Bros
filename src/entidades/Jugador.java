package entidades;

import utilidades.Animaciones;
import utilidades.ImagenURL;

import static utilidades.Archivos.*;
import static utilidades.Ayuda.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Jugador extends Entidad {
    //Animaciones
    private BufferedImage imagenes;
    private BufferedImage[][] animaciones;
    private int tick, indice, framesEntreAnimaciones = 12; // 120 FPS y 10 animaciones por segundo
    private Animaciones.Jugador accionAnterior = Animaciones.Jugador.QUIETO;
    private Animaciones.Jugador accionActual = Animaciones.Jugador.QUIETO;
    //Comportamiento
    private boolean moviendose = false;
    private boolean corriendo = false;
    private boolean mirarIzquierda = false;
    private boolean mirarDerecha = true;
    private boolean izquierda, derecha;
    private float velocidad;

    // Atributo que le pasa la informacion del nivel al jugador para que pueda moverse por el con la hitbox
    private int[][] infoNivel;

    // Variables para el salto y movimiento aereo
    private float velocidadAire = 0f;
    private float gravedad = 0.1f;
    private float velocidadSalto = -4.5f;
    private float velocidadCaida = 0.5f;
    private boolean enAire = false ,saltando = false;

    private float diferenciaHitboxX = 6, diferenciaHitboxY = 9;
    private float alturaHitbox = 55, anchuraHitbox = 25;

    //Variables para muerte y todo eso
    private int vidas = 3, inicX, inicY;

    public Jugador(float x, float y, int anchura, int altura, ImagenURL imagenURL) {
        super(x, y, anchura, altura);
        cargarAnimaciones(imagenURL);
        inicializarHitbox(x, y, anchuraHitbox, alturaHitbox);
        inicX = (int)x;
        inicY = (int)y;
    }

    public void cargarInfoNivel(int[][] infoNivel) {
        this.infoNivel = infoNivel;
    }

    public void update() {
        setPosicion();
        cambiarAccion();
        actualizarAnimacion();
    }

    public void render(Graphics g, int lvlOffset) {
//        mostrarHitbox(g);
        float x = hitbox.x - diferenciaHitboxX;
        float y = hitbox.y - diferenciaHitboxY;

        if (mirarIzquierda)
            g.drawImage(animaciones[accionActual.getPosicion()][indice], (int)(x + anchura) - lvlOffset, (int)y, -anchura, altura, null);
        else
            g.drawImage(animaciones[accionActual.getPosicion()][indice], (int)x - lvlOffset, (int)y, anchura, altura, null);
    }

    private void setPosicion() {
        moviendose = false;

        if (saltando)
            saltar();
        if (!izquierda && !derecha && !enAire)
            return;

        float xVelocidad = 0;

        if (corriendo)
            velocidad = 3f;
        else
            velocidad = 2f;

        // Esto es para que el jugador no se pueda mover si presiona derecha e izquierda a la vez
        if (izquierda) {
            xVelocidad -= velocidad;
            mirarIzquierda = true;
            mirarDerecha = false;
        }
        else if (derecha) {
            xVelocidad += velocidad;
            mirarDerecha = true;
            mirarIzquierda = false;
        }

        if (!enAire) {
            if (!enSuelo(hitbox, infoNivel))
                enAire = true;
        }

        if (enAire) {
            if (sePuedeMover(hitbox.x, hitbox.y + velocidadAire, hitbox.width, hitbox.height, infoNivel)){
                hitbox.y += velocidadAire;
                velocidadAire += gravedad;
                actualizarPosicionX(xVelocidad);
            } else {
                if (velocidadAire > 0)
                    detenerEnAire();
                else
                    velocidadAire = velocidadCaida;
                actualizarPosicionX(xVelocidad);
            }
        } else
            actualizarPosicionX(xVelocidad);

        moviendose = true;
    }

    private void saltar() {
        if (enAire)
            return;
        enAire = true;
        velocidadAire = velocidadSalto;
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


    private void cargarAnimaciones(ImagenURL imagenURL) {
        imagenes = cargarImagen(imagenURL);

        // Son 14 animaciones en total y la que tiene mas frames tiene 4
        animaciones = new BufferedImage[14][4];

        for (int j = 0; j < 14; j++) {
            for (int i = 0; i < 4; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * 20, j * 30, 20, 30);
            }
        }
    }

    private void cambiarAccion() {
        if (moviendose && corriendo && !enAire)
            accionActual = Animaciones.Jugador.CORRIENDO;
        else if (moviendose && !corriendo && !enAire)
            accionActual = Animaciones.Jugador.CAMINANDO;
        else
            accionActual = Animaciones.Jugador.QUIETO;

        if (enAire && !corriendo)
            accionActual = Animaciones.Jugador.SALTANDO;
        else if (enAire && corriendo)
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
        corriendo = false;
    }

    //Cuando choca con un emenigo
    public void golpeado(Enemigo enem){
        if(enem.getHitbox().intersects(hitbox) && enem.getEstado() != Enemigo.MORIR){
            respawn();
        }
    }
    //Cuando pisa con un emenigo
    public void pisar(Enemigo enem){
        if(enem.getPisadoBox().intersects(hitbox) && enem.getEstado() != Enemigo.MORIR){
            enAire = false;
            saltar();
            enem.setEstado(Enemigo.MORIR);
            enem.setAccionActual(Animaciones.Enemigo.MURIENDO);
        }
    }

    //Cuando pegan, vuelves al principio y pierdes vida
    public void respawn(){
        vidas--;
        hitbox.x = inicX;
        hitbox.y = inicY;
        if(vidas <= 0){
            System.out.println("Muelto");
        }
    }

    public void setCorriendo(boolean corriendo) {
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

    public void setSaltando(boolean saltando){
        this.saltando = saltando;
    }

    public boolean isEnAire() {
        return enAire;
    }
 }
