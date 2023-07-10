package entidades;

import main.Juego;
public class Goomba extends Enemigo{
    public static int handicap = 4;
    public Goomba(float x, float y) {
        super(x+handicap , y+handicap, Juego.UNIDAD-(handicap*2), Juego.UNIDAD-handicap);
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        switch(estado){
            case CAMINAR:
                caminandoIntel(infoLvl);
                break;
        }
    }
}
