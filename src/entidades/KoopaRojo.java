package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.*;

public class KoopaRojo extends Koopa{
    public KoopaRojo(float x, float y) {
        super(x+handicap , y+handicap, ImagenURL.ENEMY_KOOPAROJO, 22, 28);
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
}
