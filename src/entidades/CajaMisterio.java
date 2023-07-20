package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;
import utilidades.Ayuda;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilidades.Archivos.cargarImagen;

public abstract class CajaMisterio extends Entidad{
    static final int NOACTIVO = 0, ACTIVO = 1, SACANDO = 2;
    //Animaciones
    protected BufferedImage[][] animaciones;
    protected Animaciones.OBJ accionAnterior = Animaciones.OBJ.MOVIENDOSE_3;
    protected Animaciones.OBJ accionActual = Animaciones.OBJ.MOVIENDOSE_3;
    protected int aniIndex, aniTick, aniSpeed = 12;
    //Comportamientos
    protected int estado = ACTIVO, actAnim = ACTIVO;
    protected int regenTime = 120 * 10, currTime = 0;
    private int profundidad = 30, currProf = 0, profInterval = 10, currInterval; //Prof interval es la cantidad de frames que va a tomar bajar un pixel, para sacar el tiempo que tardara en salir es (profundidad*profInterval)/fps
    public Objeto obj;

    public CajaMisterio(float x, float y, Objeto obj) {
        super(x, y , Juego.UNIDAD, Juego.UNIDAD);
        inicializarHitbox(x, y+ Juego.UNIDAD+1, + Juego.UNIDAD, 10);
        cargarAnimaciones(ImagenURL.OBJ_MISTERIO, 16, 16);
        this.obj = obj;
    }

    // <editor-fold defaultstate="collapsed" desc="ACTUALIZACIONES DE FRAME">//GEN-BEGIN:initComponents
    public void update(int[][] infoLvl){
        actualizarAnimacion();
        comportamiento();
        obj.update(infoLvl);
    }

    // </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="COMPORTAMIENTOS GENERALES">//GEN-BEGIN:initComponents

    protected void comportamiento(){
        switch(estado){
            case NOACTIVO:
                timer();
                break;
            case SACANDO:
                sacandoObj();
                break;
        }
    }

    public void sacandoObj(){
        currInterval++;
        if(currInterval >= profInterval){
            currProf++;
            obj.hitbox.y--;
            if(currProf >= profundidad) {
                currProf = 0;
                currInterval = 0;
                obj.estado = Objeto.MOVIENDOSE;
                estado = NOACTIVO;
            }
        }
    }
    protected void timer(){
        currTime++;
        if(currTime >= regenTime){
            currTime = 0;
            estado = ACTIVO;
            accionAnterior = accionActual;
            accionActual = Animaciones.OBJ.MOVIENDOSE_3;
            obj.hitbox.x = obj.x;
            obj.hitbox.y = obj.y;
            obj.estado = Objeto.QUIETO;
            actAnim = ACTIVO;
        }
    }

    protected void desactivar(){
        estado = NOACTIVO;
        accionAnterior = accionActual;
        accionActual = Animaciones.OBJ.QUIETO;
        actAnim = NOACTIVO;
    }

    // </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="ANIMACIONES">//GEN-BEGIN:initComponents
    private void cargarAnimaciones(ImagenURL imagenURL, int x, int y) {
        BufferedImage imagenes = cargarImagen(imagenURL);

        // Son 3 animaciones en total y la que tiene mas frames tiene 2
        animaciones = new BufferedImage[2][4];

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 4; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * x, j * y, x, y);
            }
        }
    }

    public void dibujar(Graphics g, int lvlOffset){
        g.drawImage(animaciones[actAnim][aniIndex], (int)this.x - lvlOffset, (int)this.y, Juego.UNIDAD,Juego.UNIDAD,null);
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

    public int getEstado(){
        return estado;
    }
    // </editor-fold>//GEN-END:initComponents
}
