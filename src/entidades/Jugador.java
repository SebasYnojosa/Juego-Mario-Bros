package entidades;

import utilidades.Animaciones;
import utilidades.SpritesURL;

import static main.Juego.UNIDAD;
import static utilidades.Archivos.*;

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
    private boolean arriba, abajo, izquierda, derecha;
    private float velocidad;
    private static final int ALTURA = 2 * UNIDAD;
    private static final int ANCHURA = UNIDAD + UNIDAD/4;


    public Jugador(float x, float y) {
        super(x, y);
        cargarAnimaciones();
    }

    public void update() {
        setPosicion();
        cambiarAccion();
        actualizarAnimacion();
    }

    public void render(Graphics g) {
        g.drawImage(animaciones[accionActual.getPosicion()][indice], (int)x, (int)y, ANCHURA, ALTURA, null);
    }

    private void setPosicion() {
        moviendose = false;

        if (corriendo)
            velocidad = 5.0f;
        else
            velocidad = 3.5f;

        // Esto es para que el jugador no se pueda mover si presiona derecha e izquierda a la vez
        if (izquierda && !derecha) {
            x -= velocidad;
            moviendose = true;
        }
        else if (derecha && !izquierda) {
            x += velocidad;
            moviendose = true;
        }

        // Esto es para que el jugador no se pueda mover si presiona arriba y abajo a la vez
        if (arriba && !abajo) {
            y -= velocidad;
            moviendose = true;
        }
        else if (abajo && !arriba) {
            y += velocidad;
            moviendose = true;
        }
    }

    private void cargarAnimaciones() {
        imagenes = cargarSprites(SpritesURL.MARIO_SPRITESHEET);

        // Son 14 animaciones en total y la que tiene mas frames tiene 4
        animaciones = new BufferedImage[14][4];

        for (int j = 0; j < 14; j++) {
            for (int i = 0; i < 4; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * 20, j * 30, 20, 30);
            }
        }
    }

    private void cambiarAccion() {
        if (moviendose && corriendo) {
            accionActual = Animaciones.Jugador.CORRIENDO;
        }
        else if (moviendose && !corriendo) {
            accionActual = Animaciones.Jugador.CAMINANDO;
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


 }
