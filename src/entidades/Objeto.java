package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;
import utilidades.Ayuda;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilidades.Archivos.cargarImagen;

public abstract class Objeto extends Entidad{
    protected static int dif = 4;
    protected final static int QUIETO = 0, MOVIENDOSE = 1;

    //Animaciones
    protected BufferedImage[][] animaciones;
    protected Animaciones.OBJ accionAnterior, accionActual;

    protected int aniIndex, aniTick, aniSpeed = 12;

    //Comportamiento
    protected int tipo, estado;
    protected boolean start = true, enAire = false, izq = true;         //Para cuando los update se ejecuten por primera vez

    private float velocidadAire, gravedad = 0.1f, velx = 1f; //Variables de velocidad y tal

    public Objeto(float x, float y, int tipo) {
        super(x-dif, y-dif, Juego.UNIDAD-dif, Juego.UNIDAD-dif);
        inicializarHitbox(this.x,this.y, this.anchura, this.altura);
        cargarAnimaciones(ImagenURL.OBJ_ITEMS, 16, 16);
        this.tipo = tipo;
    }

    // <editor-fold defaultstate="collapsed" desc="ACTUALIZACIONES DE FRAME">//GEN-BEGIN:initComponents
    public void update(int[][] infoLvl){
        movUpdate(infoLvl);
        actualizarAnimacion();
    }

    public void movUpdate(int[][] infoLvl){
        if(start){
            if(!Ayuda.enSuelo(hitbox, infoLvl)){
                enAire = true;
            }
            start = false;
        }
        if(!enAire){
            comportamiento(infoLvl);
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

    public abstract void comportamiento(int[][] infoLvl);

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
        if(izq){
            izq = false;
        }else{
            izq = true;
        }
    }

    // </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="ANIMACIONES">//GEN-BEGIN:initComponents
    private void cargarAnimaciones(ImagenURL imagenURL, int x, int y) {
        BufferedImage imagenes = cargarImagen(imagenURL);

        // Son 3 animaciones en total y la que tiene mas frames tiene 2
        animaciones = new BufferedImage[5][4];

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 4; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * x, j * y, x, y);
            }
        }
    }

    public void dibujar(Graphics g, int lvlOffset){
        g.drawImage(animaciones[tipo][aniIndex], (int)this.x - lvlOffset, (int)this.y, Juego.UNIDAD,Juego.UNIDAD,null);
    }

    public void actualizarAnimacion(){
        // Si la accion actual es diferente a la accion anterior, se reinicia el indice
        // Esto para evitar parpadeos en el cambio de animaciones
        if (accionActual != accionAnterior) {
            aniIndex = 0;
            accionAnterior = accionActual;
        }

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

    public int getTipo(){
        return tipo;
    }
    // </editor-fold>//GEN-END:initComponents
}
