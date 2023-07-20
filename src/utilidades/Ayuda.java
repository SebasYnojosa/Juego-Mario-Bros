package utilidades;

import entidades.*;
import main.Juego;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import static main.Juego.UNIDAD;

public class Ayuda {

    // Coleccion de bloques transparentes

    public static ArrayList<Integer> transparentes = new ArrayList<>(Arrays.asList(2, 126, 127, 128, 129, 130, 131, 142, 143, 150, 151, 152, 153, 154));

    // Metodo que se encarga de verificar si la entidad se puede mover a la posicion indicada
    public static boolean sePuedeMover(float x, float y, float anchura, float altura, int[][] infoNivel) {
        if (!esSolido(x,y,infoNivel) && !esSolido(x+anchura,y,infoNivel) &&
                !esSolido(x,y+altura,infoNivel) && !esSolido(x+anchura,y+altura,infoNivel) &&
                !esSolido(x,y+altura/2,infoNivel) && !esSolido(x+anchura, y+altura/2,infoNivel))
            return true;
        else
            return false;
    }

    public static boolean esSolido(float x, float y, int[][] infoNivel) {
        int anchuraMaxima = infoNivel[0].length * UNIDAD;
        int alturaMaxima = infoNivel.length * UNIDAD;

        if (x < 0 || x >= anchuraMaxima)
            return true;

        float xIndice = x / UNIDAD;
        float yIndice = y / UNIDAD;

        // Permite a las entidades caerse en un pozo sin que explote el programa
        if (y < 0 || y >= alturaMaxima)
            return false;

        int valor = infoNivel[(int)yIndice][(int)xIndice];

        // valor == 2 es el valor del bloque que es transparente
        if (valor >= 178 || valor < 0 || !transparentes.contains(valor))
            return true;
        else
            return false;
    }


    public static boolean enSuelo(Rectangle2D.Float hitbox, int[][] infoNivel) {
        if (!esSolido(hitbox.x, hitbox.y+ hitbox.height+1, infoNivel))
            if (!esSolido(hitbox.x + hitbox.width, hitbox.y + hitbox.height+1, infoNivel))
                return false;
        return true;
    }

    public static boolean eneSueloInteligente(Rectangle2D.Float hitbox, float vel, boolean izq, int[][] infoNivel){
        if(izq)
            return esSolido(hitbox.x + vel, hitbox.y + hitbox.height + 2, infoNivel);
        return esSolido(hitbox.x + vel + Juego.UNIDAD, hitbox.y + hitbox.height + 2, infoNivel);
    }


    // Funcion que carga la informacion del nivel de un mapa de bits y la devuelve en una matriz para poder dibujarlo en el juego
    // El valor del color rojo de cada pixel del mapa de bits representa un bloque del nivel

    public static int[][] informacionDelNivel(BufferedImage img) {

        int[][] infoNivel = new int[img.getHeight()][img.getWidth()];

        for (int j = 0; j < img.getHeight(); ++j)
            for (int i = 0; i < img.getWidth(); ++i){
                Color color = new Color(img.getRGB(i, j));
                int valor = color.getRed();
                if (valor >= 176)
                    valor = 0;
                infoNivel[j][i] = valor;
            }

        return infoNivel;
    }

    //Funcion que devuelve un arrayList con los goombas
    //El nivel de verde en el pixel de bitmap indica que hay un goomba
    //Estos son los valores de verde para cada enemigo
    static final int GOOMBA = 5;
    static final int KOOPA_VERDE = 10;
    static final int KOOPA_ROJO = 15;
    static final int SPINY = 20;
    static final int SCURRY = 25;
    static final int PIRA = 30;

    public static ArrayList<Enemigo> getEnemigos(BufferedImage img){
        ArrayList<Enemigo> lista = new ArrayList();
        for (int j = 0; j < img.getHeight(); ++j)
            for (int i = 0; i < img.getWidth(); ++i){
                Color color = new Color(img.getRGB(i, j));
                int valor = color.getGreen();
                switch(valor){
                    case GOOMBA: lista.add(new Goomba(i*Juego.UNIDAD,j*Juego.UNIDAD));break;
                    case KOOPA_VERDE: lista.add(new KoopaVerde(i*Juego.UNIDAD,j*Juego.UNIDAD));break;
                    case KOOPA_ROJO: lista.add(new KoopaRojo(i*Juego.UNIDAD,j*Juego.UNIDAD));break;
                    case SPINY: lista.add(new Spiny(i*Juego.UNIDAD,j*Juego.UNIDAD));break;
                    case SCURRY: lista.add(new Scurry(i*Juego.UNIDAD,j*Juego.UNIDAD)); break;
                    case PIRA: lista.add(new Pira(i*Juego.UNIDAD,j*Juego.UNIDAD)); break;
                }
            }
        return lista;
    }

    //Funcion que devuelve un arrayList con los goombas
    //El nivel de verde en el pixel de bitmap indica que hay un goomba
    //Estos son los valores de verde para cada enemigo
    //static final int HONGO = 100;
    static final int FLOR = 101;
    static final int UP = 102;
    public static ArrayList<CajaMisterio> getCajas(BufferedImage img){
        ArrayList<CajaMisterio> lista = new ArrayList();
        for (int j = 0; j < img.getHeight(); ++j)
            for (int i = 0; i < img.getWidth(); ++i){
                Color color = new Color(img.getRGB(i, j));
                int valor = color.getGreen();
                switch(valor){
                    //case HONGO: break;
                    case FLOR: lista.add(new CajaMisterio(i*Juego.UNIDAD,j*Juego.UNIDAD, new Flor(i*Juego.UNIDAD, j*Juego.UNIDAD))); break;
                    case UP: lista.add(new CajaMisterio(i*Juego.UNIDAD,j*Juego.UNIDAD, new Up(i*Juego.UNIDAD, j*Juego.UNIDAD))); break;
                }
            }
        return lista;
    }
}
