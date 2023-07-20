package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Pira extends Enemigo{
    public static final int IDLE = 0, SALIR = 2, ENTRAR = 3;
    private int salidaTime = 120 * 2, currTime = 0;
    private int profundidad = 34, currProf = 0, profInterval = 10, currInterval; //Prof interval es la cantidad de frames que va a tomar bajar un pixel, para sacar el tiempo que tardara en salir es (profundidad*profInterval)/fps
    private int estadoAnt = SALIR;

    private float inicialY;

    public Pira(float x, float y) {
        super(x+handicap+(Juego.UNIDAD/2) , y+handicap, Juego.UNIDAD-(handicap*2), (Juego.UNIDAD)-handicap, ImagenURL.ENEMY_PIRA, 16, 22);
        inicialY = y;
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        switch(estado){
            case IDLE:
                idle();
                break;
            case SALIR:
                salir();
                break;
            case ENTRAR:
                entrar();
                break;
            case MORIR:
                morir();
                break;
        }
    }

    private void idle(){
        currTime++;
        if(currTime >= salidaTime){
            if(estadoAnt == SALIR){
                estado = estadoAnt = ENTRAR;
            }else{
                estado = estadoAnt = SALIR;
            }
            currTime = 0;
        }
    }

    private void salir(){
        currInterval++;
        if(currInterval >= profInterval){
            currProf++;
            hitbox.y--;
            if(currProf >= profundidad) {
                currProf = 0;
                currInterval = 0;
                estado = IDLE;
            }
        }
    }

    private void entrar(){
        currInterval++;
        if(currInterval >= profInterval){
            currProf++;
            hitbox.y++;
            if(currProf >= profundidad) {
                currProf = 0;
                currInterval = 0;
                estado = IDLE;
            }
        }
    }

    @Override
    public void morir(){
        currTime = 0;
        currProf = 0;
        estado = IDLE;
        estadoAnt = ENTRAR;
        hitbox.y = inicialY + profundidad;
    }

    @Override
    public void dibujar(Graphics g, int lvlOffset){
        if(izq)
            g.drawImage(animaciones[0][aniIndex], (int)getHitbox().x-handicap - lvlOffset, (int)getHitbox().y-handicap, Juego.UNIDAD,Juego.UNIDAD,null);
        else
            g.drawImage(animaciones[0][aniIndex], (int)getHitbox().x-handicap + Juego.UNIDAD - lvlOffset, (int)getHitbox().y-handicap, -Juego.UNIDAD,Juego.UNIDAD,null);
    }

    @Override
    protected void inicializarPisadobox(float x, float y, float anchura, float altura) {
        pisadoBox = new Rectangle2D.Float(-5, -5, 0, 0);
    }
}
