package utilidades;

import main.Juego;
import entidades.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Archivos {

    public static BufferedImage cargarImagen(ImagenURL imagenURL) {
        BufferedImage img = null;
        InputStream is = Archivos.class.getClassLoader().getResourceAsStream(imagenURL.getSpriteURL());
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return img;
    }

    //Funcion que devuelve un arrayList con los goombas
    //El nivel de verde en el pixel de bitmap indica que hay un goomba
    //Estos son los valores de verde para cada enemigo
    static final int GOOMBA = 5;
    static final int KOOPA_VERDE = 10;
    static final int KOOPA_ROJO = 15;
    static final int SPINY = 20;
    public static ArrayList<Enemigo> getEnemigos(){
        BufferedImage img = cargarImagen(ImagenURL.INFO_NIVEL_CAVERNA);
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
                }
            }
        return lista;
    }

    // Funcion que carga la informacion del nivel de un mapa de bits y la devuelve en una matriz para poder dibujarlo en el juego
    // El valor del color rojo de cada pixel del mapa de bits representa un bloque del nivel

    public static int[][] informacionDelNivel() {
        BufferedImage img = cargarImagen(ImagenURL.INFO_NIVEL_CAVERNA);
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
}
