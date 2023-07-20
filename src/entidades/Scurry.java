package entidades;

import main.Juego;
import utilidades.ImagenURL;

import java.awt.*;

public class Scurry extends Koopa{
    public Scurry(float x, float y) {
        super(x+handicap , y+handicap, ImagenURL.ENEMY_SKURRY, 16, 16);
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        switch(estado){
            case CAMINAR:
                caminandoIntel(infoLvl);
                break;
            case CAPARAZON:
                caparazon();
                break;
            case CAPARAZONGIRO:
                caparazonGiro(infoLvl);
                break;
            case MORIR:
                morir();
                break;
        }
    }

    @Override
    public void dibujar(Graphics g, int lvlOffset){
        if(izq)
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-handicap - lvlOffset, (int)getHitbox().y-(handicap+(Juego.UNIDAD/2)), Juego.UNIDAD,Juego.UNIDAD,null);
        else
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-handicap + Juego.UNIDAD - lvlOffset, (int)getHitbox().y-(handicap+(Juego.UNIDAD/2)), -Juego.UNIDAD,Juego.UNIDAD,null);
    }
}
