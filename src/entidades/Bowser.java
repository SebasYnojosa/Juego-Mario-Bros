package entidades;


import java.util.Random;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;
import utilidades.Ayuda;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Bowser extends Enemigo{

    //Control de acciones
    private final static int QUIETO = 0, DISPARAR = 1, SALTAR = 2, MORIRV = 3;
    private Random intel = new Random();
    private int accionTime = 120 * 3, currTime;
    private int accion;
    private float velocidadSalto = -4.5f;

    private int distanciaIdle = Juego.UNIDAD * 2, currDis = 0;

    //Control de vida y tal
    public int vida = 10;
    private int bajarInterval = 120/5, currInterval = 0;


    public Bowser(float x, float y) {
        super(x, y, Juego.UNIDAD * 2, (Juego.UNIDAD * 3)-16, ImagenURL.BOSS_BOWSER, 34, 48);
        accionActual = Animaciones.Enemigo.QUIETO;
        estado = QUIETO;
        gravedad = 0.05f;
        izq = true;
    }

    // <editor-fold defaultstate="collapsed" desc="COMPORTAMIENTOS GENERALES">//GEN-BEGIN:initComponents

    @Override
    public void comportamiento(int[][] infoLvl) {
        switch(estado){
            case CAMINAR:
                patrullar(infoLvl);
                break;
            case MORIR:
                morir();
                break;
            case MORIRV:
                morirVerdad();
                break;
        }
        if(estado != MORIRV){
            decision();
        }
    }

    private void patrullar(int[][] infoLvl){

        float vel; //Variable de la velocidad con direccion
        if(izq){
            vel = -velx;
        }else{
            vel = velx;
        }

        if(Ayuda.sePuedeMover(hitbox.x, hitbox.y+ velocidadAire, hitbox.width, hitbox.height, infoLvl)){
            enAire = true;
        }

        if(Ayuda.sePuedeMover(hitbox.x + vel, hitbox.y, hitbox.width, hitbox.height, infoLvl) && currDis <= distanciaIdle){
            hitbox.x += vel;
            pisadoBox.x += vel;
            currDis++;
            return;
        }
        if(izq){
            izq = false;
        }else{
            izq = true;
        }
        currDis = 0;

    }

    private void saltar() {
        if (enAire)
            return;
        enAire = true;
        velocidadAire = velocidadSalto;
    }

    @Override
    public void morir() {
        vida--;
        estado = QUIETO;
        if(vida <= 0){
            estado = MORIRV;
        }
    }

    private void morirVerdad(){
        hitbox.y++;
    }

    private void decision(){
        currTime++;
        if(currTime >= accionTime){
            currTime = 0;
            accion = intel.nextInt(3);
            switch(accion){
                case QUIETO:
                    estado = QUIETO;
                    break;
                case SALTAR:
                    saltar();
                    estado = QUIETO;
                    break;
                case Enemigo.MORIR:
            }
        }
    }
    // </editor-fold>//GEN-END:initComponents

    @Override
    public void dibujar(Graphics g, int lvlOffset){
        g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-handicap - lvlOffset, (int)getHitbox().y-(handicap*2), anchura+20+16,altura+16,null);
    }

    @Override
    protected void inicializarPisadobox(float x, float y, float anchura, float altura) {
        pisadoBox = new Rectangle2D.Float(-5, -5, 0, 0);
    }
}
