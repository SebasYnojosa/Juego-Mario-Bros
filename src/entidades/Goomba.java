package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.image.BufferedImage;

public class Goomba extends Enemigo{
    //Respawn del goomba
    public static final int respawnTime = 120 * 3;
    private int respawnTick = respawnTime;

    //Hitbox
    public static int handicap = 4;
    public Goomba(float x, float y) {
        super(x+handicap , y+handicap, Juego.UNIDAD-(handicap*2), (Juego.UNIDAD/2)-handicap, ImagenURL.ENEMY_GOOMBA);
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

    //Estados customizados para los goombas
    //Para que revivan luego de un rato
    @Override
    public void morir(){
        respawnTick--;
        if(respawnTick <= 0){

            accionActual = Animaciones.Enemigo.CAMINANDO;
            estado = CAMINAR;

            respawnTick = respawnTime;
        }
    }
}
