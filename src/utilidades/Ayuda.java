package utilidades;

import main.Juego;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.security.cert.TrustAnchor;

import static main.Juego.UNIDAD;

public class Ayuda {

    // Metodo que se encarga de verificar si la entidad se puede mover a la posicion indicada
    public static boolean sePuedeMover(float x, float y, float anchura, float altura, int[][] infoNivel) {
        if (!esSolido(x,y,infoNivel) && !esSolido(x+anchura,y,infoNivel) && !esSolido(x,y+altura,infoNivel) && !esSolido(x+anchura,y+altura,infoNivel))
            return true;
        else
            return false;
    }

    public static boolean esSolido(float x, float y, int[][] infoNivel) {
        if (x < 0 || y < 0 || x >= Juego.ANCHO_VENTANA || y >= Juego.ALTO_VENTANA)
            return true;

        float xIndice = x / UNIDAD;
        float yIndice = y / UNIDAD;

        int valor = infoNivel[(int)yIndice][(int)xIndice];

        // valor == 2 es el valor del bloque que es transparente
        if (valor >= 178 || valor < 0 || valor != 2)
            return true;
        else
            return false;
    }

    public static boolean enSuelo(Rectangle2D.Float hitbox, int[][] infoNivel) {
        if (!esSolido(hitbox.x, hitbox.y+ hitbox.height+1, infoNivel))
            if (!esSolido(hitbox.x + hitbox.width, hitbox.y + hitbox.height+1, infoNivel))
                return false;
        return true;
    }

    public static boolean eneSueloInteligente(Rectangle2D.Float hitbox, float vel, boolean izq, int[][] infoNivel){
        if(izq)
            return esSolido(hitbox.x + vel, hitbox.y + hitbox.height + 2, infoNivel);
        return esSolido(hitbox.x + vel + Juego.UNIDAD, hitbox.y + hitbox.height + 2, infoNivel);
    }
}
