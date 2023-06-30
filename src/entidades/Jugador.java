package entidades;

import main.Juego;
import utilidades.SpritesURL;

import static main.Juego.UNIDAD;
import static utilidades.Archivos.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Jugador extends Entidad {

    private BufferedImage imagenes;
    private boolean moviendose = false;
    private boolean arriba, abajo, izquierda, derecha;
    private float velocidad = 3.5f;
    public Jugador(float x, float y) {
        super(x, y);
    }

    public void update() {
        setPosicion();
        cargarAnimaciones();
    }

    public void render(Graphics g) {
        g.drawImage(imagenes, (int)x, (int)y, UNIDAD, UNIDAD + UNIDAD/2, null);
    }

    private void setPosicion() {
        moviendose = false;

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
        imagenes = cargarSprites(SpritesURL.MARIO);
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

    public void resetDirecciones() {
        izquierda = arriba = abajo = derecha = false;
    }
 }
