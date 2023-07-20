package menus;

import main.Juego;
import utilidades.Archivos;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NivelCompletado {

    // Atributos de la clase

    private Juego juego;
    private BufferedImage img;
    private int fondoX, fondoY, fondoAltura, fondoAncho;

    // Constructor de la clase

    public NivelCompletado(Juego juego){
        this.juego = juego;
        iniciarImg();
    }

    // Metodos de la clase

    public void iniciarImg(){
        img = Archivos.cargarImagen(ImagenURL.CAMBIO_NIVEL_UNO);
        fondoAncho = (int) (img.getWidth() * Juego.UNIDAD);
        fondoAltura = (int) (img.getHeight() * Juego.UNIDAD);
        fondoX = Juego.UNIDADES_ANCHO / 2 - fondoAncho / 2;
        fondoY = (int) (75 * Juego.UNIDAD);
    }

    public void update(){

    }

    public void draw(Graphics g){
        g.drawImage(img, fondoX, fondoY, fondoAncho, fondoAltura, null);
    }
}
