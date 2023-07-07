package utilidades;

import main.Juego;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

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

    // Funcion que carga la informacion del nivel de un mapa de bits y la devuelve en una matriz para poder dibujarlo en el juego
    // El valor del color rojo de cada pixel del mapa de bits representa un bloque del nivel
    public static int[][] informacionDelNivel() {
        int[][] infoNivel = new int[Juego.UNIDADES_ALTURA][Juego.UNIDADES_ANCHO];
        BufferedImage img = cargarImagen(ImagenURL.INFO_NIVEL_UNO);

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
