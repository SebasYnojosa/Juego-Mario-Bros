package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.Ayuda;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Juego.ALTO_VENTANA;
import static utilidades.Archivos.cargarImagen;

public class Fuego extends Entidad{

    //Animaciones
    protected BufferedImage[][] animaciones;
    protected Animaciones.OBJ accionActual = Animaciones.OBJ.MOVIENDOSE_2;

    protected int aniIndex, aniTick, aniSpeed = 12;

    //Comportamiento
    protected boolean start = true, enAire = false, izq = true;         //Para cuando los update se ejecuten por primera vez
    private float velocidadAire, gravedad = 0.1f, velx = 2f; //Variables de velocidad y tal

    public boolean activo = false;

    public Fuego(float x, float y) {
        super(x, y, Juego.UNIDAD/2, Juego.UNIDAD/2);
        inicializarHitbox(this.x,this.y, this.anchura, this.altura);
        cargarAnimaciones(ImagenURL.ENT_FUEGO, 8, 8);
    }

    // <editor-fold defaultstate="collapsed" desc="ACTUALIZACIONES DE FRAME">//GEN-BEGIN:initComponents
    public void update(int[][] infoLvl){
        if(activo){
            movUpdate(infoLvl);
            actualizarAnimacion();
        }
    }

    public void movUpdate(int[][] infoLvl){
        // Hace que el jugador muera cuando se cae del escenario
        if (hitbox.y > ALTO_VENTANA + altura) {
            respawn();
            return;
        }

        if(start){
            if(!Ayuda.enSuelo(hitbox, infoLvl)){
                enAire = true;
            }
            start = false;
        }
        if(!enAire){
            caminando(infoLvl);
        }else{
            //Caer
            if(Ayuda.sePuedeMover(hitbox.x, hitbox.y+ velocidadAire, hitbox.width, hitbox.height, infoLvl)){
                hitbox.y += velocidadAire;
                velocidadAire += gravedad;
            }else{
                enAire = false;
            }
        }
    }

    // </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="COMPORTAMIENTOS GENERALES">//GEN-BEGIN:initComponents

    public void caminando(int[][] infoLvl){
        float vel = 0; //Variable de la velocidad con direccion
        if(izq){
            vel = -velx;
        }else{
            vel = velx;
        }

        if(Ayuda.sePuedeMover(hitbox.x, hitbox.y+ velocidadAire, hitbox.width, hitbox.height, infoLvl)){
            enAire = true;
        }

        if(Ayuda.sePuedeMover(hitbox.x + vel, hitbox.y, hitbox.width, hitbox.height, infoLvl)){
            hitbox.x += vel;
            return;
        }
        respawn();
    }

    public void spawn(float x,float y, boolean izq){
        activo = true;
        this.hitbox.x = x;
        this.hitbox.y = y;
        this.izq = izq;
    }

    public void respawn(){
        this.hitbox.x = this.x;
        this.hitbox.y = this.y;
        start = true;
        enAire = false;
        izq = true;
        velocidadAire = 0;
        activo = false;
    }

    // </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="ANIMACIONES">//GEN-BEGIN:initComponents
    private void cargarAnimaciones(ImagenURL imagenURL, int x, int y) {
        BufferedImage imagenes = cargarImagen(imagenURL);

        // Son 3 animaciones en total y la que tiene mas frames tiene 2
        animaciones = new BufferedImage[1][2];

        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < 2; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * x, j * y, x, y);
            }
        }
    }

    public void dibujar(Graphics g, int lvlOffset){
        g.drawImage(animaciones[0][aniIndex], (int)hitbox.x - lvlOffset, (int)hitbox.y, this.anchura,this.altura,null);
    }

    public void actualizarAnimacion(){

        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            //Aqui va el sprite, ojo
            if (aniIndex >= accionActual.getCantidadDeFrames()) {
                aniIndex = 0;
            }
        }
    }
    // </editor-fold>//GEN-END:initComponents
}
