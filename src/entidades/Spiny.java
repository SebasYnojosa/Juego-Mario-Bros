package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Spiny extends Enemigo{
    public Spiny(float x, float y) {
        super(x+handicap , y+handicap, Juego.UNIDAD-(handicap*2), Juego.UNIDAD-handicap, ImagenURL.ENEMY_SPINY, 16, 16);
    }


    @Override
    public void morir() {
        accionActual = Animaciones.Enemigo.MURIENDO;
        caparazon();
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        switch(estado){
            case CAMINAR:
                caminandoIntel(infoLvl);
                break;
            case MORIR:
                morir();
                break;
        }
    }

    @Override
    protected void inicializarPisadobox(float x, float y, float anchura, float altura) {
        pisadoBox = new Rectangle2D.Float(-5, -5, 0, 0);
    }

    @Override
    public void dibujar(Graphics g, int lvlOffset){
        if(izq)
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-handicap - lvlOffset, (int)getHitbox().y-handicap, Juego.UNIDAD,Juego.UNIDAD,null);
        else
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-handicap + Juego.UNIDAD - lvlOffset, (int)getHitbox().y-handicap, -Juego.UNIDAD,Juego.UNIDAD,null);
    }
}
