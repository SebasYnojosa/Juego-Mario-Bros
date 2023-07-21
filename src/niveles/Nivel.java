package niveles;

import entidades.CajaMisterio;
import entidades.Enemigo;
import entidades.Moneda;
import main.Juego;
import utilidades.Archivos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilidades.Ayuda.*;

public class Nivel {

    // Atributos de la clase

    private int[][] infoNivel;
    private BufferedImage img;
    private ArrayList<Enemigo> enemigos;
    private ArrayList<CajaMisterio> cajas;
    private ArrayList<Moneda> monedas;
    private int lvlCasillaAncho;
    private int maxCasillaOffset;
    private int maxLvlOffsetX;

    public Nivel(BufferedImage img) {
        this.img = img;
        crearInfoNivel();
        crearEnemigos();
        crearCubos();
        crearMonedas();
        calcularOffsetNivel();
    }

    // Metodos de la clase

    public void crearInfoNivel(){
        infoNivel = informacionDelNivel(img);
    }

    public void crearEnemigos(){
        enemigos = getEnemigos(img);
    }

    public void crearCubos(){
        cajas = getCajas(img);
    }

    public void crearMonedas(){monedas = getMonedas(img);}

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
    public ArrayList<CajaMisterio> getListaCajas(){
        return cajas;
    }
    public ArrayList<Moneda> getListaMonedas(){return monedas;}
}
