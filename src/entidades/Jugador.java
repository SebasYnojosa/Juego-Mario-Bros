package entidades;

import utilidades.Animaciones;
import utilidades.ImagenURL;

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
    private boolean corriendo = false;
    private boolean agachado = false;
    private boolean mirarIzquierda = false;
    private boolean mirarDerecha = true;
    private boolean arriba, abajo, izquierda, derecha;
    private float velocidad;

    // Atributo que le pasa la informacion del nivel al jugador para que pueda moverse por el con la hitbox
    private int[][] infoNivel;

    private float diferenciaHitboxX = 6, diferenciaHitboxY = 9;
    private float alturaHitbox = 55, anchuraHitbox = 25;


    public Jugador(float x, float y, int anchura, int altura) {
        super(x, y, anchura, altura);
        cargarAnimaciones();
        inicializarHitbox(x, y, anchuraHitbox, alturaHitbox);
    }

    public void cargarInfoNivel(int[][] infoNivel) {
        this.infoNivel = infoNivel;
    }

    public void update() {
        setPosicion();
        cambiarAccion();
        actualizarAnimacion();
    }

    public void render(Graphics g) {
        mostrarHitbox(g);
//        if (mirarIzquierda)
//            // -ANCHURA hace que se voltee el sprite
//            g.drawImage(animaciones[accionActual.getPosicion()][indice], (int)(hitbox.x+anchura - diferenciaHitboxX), (int)(hitbox.y - diferenciaHitboxY), -anchura, altura, null);
//        else
//            // ANCHURA hace que se dibuje el sprite de forma normal y el x-ANCHURA sirve para que el sprite no
//            g.drawImage(animaciones[accionActual.getPosicion()][indice], (int)(hitbox.x - diferenciaHitboxX), (int)(hitbox.y - diferenciaHitboxY), anchura, altura, null);
        float x = hitbox.x - diferenciaHitboxX;
        float y = hitbox.y - diferenciaHitboxY;
        if (mirarIzquierda)
            g.drawImage(animaciones[accionActual.getPosicion()][indice], (int)(x + anchura), (int)y, -anchura, altura, null);
        else
            g.drawImage(animaciones[accionActual.getPosicion()][indice], (int)x, (int)y, anchura, altura, null);
    }

    private void setPosicion() {
        moviendose = false;
        if (!izquierda && !derecha && !arriba && !abajo)
            return;

        float xVelocidad = 0, yVelocidad = 0;

        if (corriendo)
            velocidad = 5.0f;
        else
            velocidad = 3.5f;

        if (!agachado) {
            // Esto es para que el jugador no se pueda mover si presiona derecha e izquierda a la vez
            if (izquierda && !derecha) {
                xVelocidad = -velocidad;
                mirarIzquierda = true;
                mirarDerecha = false;
            }
            else if (derecha && !izquierda) {
                xVelocidad = velocidad;
                mirarDerecha = true;
                mirarIzquierda = false;
            }


            // Esto es para que el jugador no se pueda mover si presiona arriba y abajo a la vez
            if (arriba && !abajo)
                yVelocidad = -velocidad;
            else if (abajo && !arriba)
                yVelocidad = velocidad;

            if(sePuedeMover(hitbox.x + xVelocidad, hitbox.y + yVelocidad, hitbox.width, hitbox.height, infoNivel)) {
                hitbox.x += xVelocidad;
                hitbox.y += yVelocidad;
                moviendose = true;
            }
        }
    }

    private void cargarAnimaciones() {
        imagenes = cargarImagen(ImagenURL.MARIO_SPRITESHEET);

        // Son 14 animaciones en total y la que tiene mas frames tiene 4
        animaciones = new BufferedImage[14][4];

        for (int j = 0; j < 14; j++) {
            for (int i = 0; i < 4; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * 20, j * 30, 20, 30);
            }
        }
    }

    private void cambiarAccion() {
        if (moviendose && corriendo && !agachado) {
            accionActual = Animaciones.Jugador.CORRIENDO;
        }
        else if (moviendose && !corriendo && !agachado) {
            accionActual = Animaciones.Jugador.CAMINANDO;
        }
        else if (agachado) {
            accionActual = Animaciones.Jugador.AGACHADO;
        }
        else {
            accionActual = Animaciones.Jugador.QUIETO;
        }
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
        izquierda = arriba = abajo = derecha = false;
        corriendo = false;
        agachado = false;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public boolean isArriba() {
        return arriba;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public void setAbajo(boolean abajo) {
        this.abajo = abajo;
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

    public void setAgachado(boolean agachado) {
        this.agachado = agachado;
    }
 }
