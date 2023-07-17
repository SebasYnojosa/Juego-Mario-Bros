package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.image.BufferedImage;

public class Goomba extends Enemigo{
    public Goomba(float x, float y) {
        super(x+handicap , y+handicap, Juego.UNIDAD-(handicap*2), (Juego.UNIDAD/2)-handicap, ImagenURL.ENEMY_GOOMBA, 16, 16);
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        switch(estado){
            case CAMINAR:
                caminando(infoLvl);
                break;
            case MORIR:
                morir();
                break;
        }
    }

    @Override
    public void morir(){
        accionActual = Animaciones.Enemigo.MURIENDO;
        caparazon();
    }
}
