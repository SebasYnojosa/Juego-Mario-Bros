package niveles;

import entidades.Enemigo;
import main.Juego;
import utilidades.Archivos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilidades.Ayuda.informacionDelNivel;
import static utilidades.Ayuda.getEnemigos;

public class Nivel {

    // Atributos de la clase

    private int[][] infoNivel;
    private BufferedImage img;
    private ArrayList<Enemigo> enemigos;
    private int lvlCasillaAncho;
    private int maxCasillaOffset;
    private int maxLvlOffsetX;

    public Nivel(BufferedImage img) {
        this.img = img;
        crearInfoNivel();
        crearEnemigos();
        calcularOffsetNivel();
    }

    // Metodos de la clase

    public void crearInfoNivel(){
        infoNivel = informacionDelNivel(img);
    }

    public void crearEnemigos(){
        enemigos = getEnemigos(img);
    }

    public void calcularOffsetNivel(){
        lvlCasillaAncho = img.getWidth();
        maxCasillaOffset = lvlCasillaAncho - Juego.UNIDADES_ANCHO;
        maxLvlOffsetX = Juego.UNIDAD * maxCasillaOffset;
    }

    public int getIndice(int x, int y) {
        return infoNivel[y][x];
    }

    public int[][] getInfoNivel() {
        return infoNivel;
    }

    public int getLvlOffset(){
        return maxLvlOffsetX;
    }

    public ArrayList<Enemigo> getEnemigo(){
        return enemigos;
    }
}
