package utilidades;

import main.Juego;
import entidades.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
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


    public static BufferedImage[] getTodosNiveles(){
        URL url = ImagenURL.class.getResource("/lvls");
        File archivo = null;

        try {
            archivo = new File(url.toURI());
        } catch (URISyntaxException e){
            e.printStackTrace();
        }

        File[] archivos = archivo.listFiles();
        File[] archivosOrdenados = new File[archivos.length];

        for (int i = 0; i < archivosOrdenados.length; i++){
            for (int j = 0; j < archivos.length; j++){
                if (archivos[j].getName().equals((i + 1) + ".png")){
                    archivosOrdenados[i] = archivos[j];
                }
            }
        }

        BufferedImage[] imgs = new BufferedImage[archivosOrdenados.length];

        for (int i = 0; i < imgs.length; i++){
            try{
                imgs[i] = ImageIO.read(archivosOrdenados[i]);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return imgs;
    }
}
