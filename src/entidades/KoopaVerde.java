package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.*;

public class KoopaVerde extends Koopa{

    public KoopaVerde(float x, float y) {
        super(x+handicap , y+handicap,ImagenURL.ENEMY_KOOPAVERDE, 22, 28);
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        switch(estado){
            case CAMINAR:
                caminando(infoLvl);
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
