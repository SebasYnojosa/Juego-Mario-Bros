package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilidades.Archivos.cargarImagen;

public class Moneda extends Entidad{
    //Animaciones
    protected BufferedImage[][] animaciones;
    protected Animaciones.OBJ accionActual = Animaciones.OBJ.MOVIENDOSE_4;

    protected int aniIndex, aniTick, aniSpeed = 12;

    //Comportamiento
    public boolean activo = true;

    public Moneda(float x, float y) {
        super(x+4, y, Juego.UNIDAD-8, Juego.UNIDAD);
        cargarAnimaciones(ImagenURL.OBJ_MONEDAS, 12,16);
        inicializarHitbox(x, y,Juego.UNIDAD/2-4, Juego.UNIDAD/2);
    }

    public void update(){
        actualizarAnimacion();
    }

    // <editor-fold defaultstate="collapsed" desc="ANIMACIONES">//GEN-BEGIN:initComponents
    private void cargarAnimaciones(ImagenURL imagenURL, int x, int y) {
        BufferedImage imagenes = cargarImagen(imagenURL);

        // Son 3 animaciones en total y la que tiene mas frames tiene 2
        animaciones = new BufferedImage[1][4];

        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < 4; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * x, j * y, x, y);
            }
        }
    }

    public void dibujar(Graphics g, int lvlOffset){
        if(activo)
            g.drawImage(animaciones[0][aniIndex], (int)hitbox.x - lvlOffset, (int)hitbox.y, this.anchura,this.altura,null);
    }

    private void actualizarAnimacion(){
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
}
