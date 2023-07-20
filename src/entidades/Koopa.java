package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.*;

public abstract class Koopa extends Enemigo{
    protected int estadoAnt;
    public Koopa(float x, float y, ImagenURL imagenURL, int spriteX, int spriteY) {
        super(x, y, Juego.UNIDAD-(handicap*2), (Juego.UNIDAD/2)-handicap, imagenURL, spriteX, spriteY);
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
}

