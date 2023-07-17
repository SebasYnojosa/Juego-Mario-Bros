package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.*;

public class KoopaRojo extends Enemigo{
    protected int estadoAnt;
    public KoopaRojo(float x, float y) {
        super(x+handicap , y+handicap, Juego.UNIDAD-(handicap*2), (Juego.UNIDAD/2)-handicap, ImagenURL.ENEMY_KOOPAROJO, 22, 28);
    }

    @Override
    public void morir() {
        if (estadoAnt != CAPARAZON){
            respawnTick = respawnTime;
            estado = CAPARAZON;
            accionActual = Animaciones.Enemigo.CAPARAZON;
        }else{
            estado = CAPARAZONGIRO;
            accionActual = Animaciones.Enemigo.CAPARAZON_GIRO;
        }
    }

    @Override
    public void dibujar(Graphics g, int lvlOffset){
        if(izq)
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-handicap - lvlOffset, (int)getHitbox().y-(handicap+(Juego.UNIDAD/2))-14, Juego.UNIDAD,Juego.UNIDAD+14,null);
        else
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-handicap + Juego.UNIDAD - lvlOffset, (int)getHitbox().y-(handicap+(Juego.UNIDAD/2))-14, -Juego.UNIDAD,Juego.UNIDAD+14,null);
    }

    @Override
    public void setEstado(int estado){
        estadoAnt = this.estado;
        this.estado = estado;
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
