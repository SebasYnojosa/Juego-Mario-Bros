package niveles;

import main.Juego;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Juego.UNIDAD;
import static utilidades.Archivos.*;

// Clase que se encarga de manejar los niveles del juego
public class ManejaNiveles {

    private Juego juego;
    private BufferedImage[] nivelSprites;
    private Nivel nivel1;

    private BufferedImage fondo;

    public ManejaNiveles(Juego juego) {
        this.juego = juego;
        cargarSpritesNivel();
        nivel1 = new Nivel(informacionDelNivel());
    }

    public void cargarSpritesNivel() {
        BufferedImage img = cargarImagen(ImagenURL.NIVEL_CASTILLO);
        nivelSprites = new BufferedImage[16*11];
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 16; i++) {
                int indice = j * 16 + i;
                nivelSprites[indice] = img.getSubimage(i * 16, j * 16, 16, 16);
            }
        }
        fondo = cargarImagen(ImagenURL.FONDO_CASTILLO);
    }

    public void render(Graphics g, int lvlOffset) {
        g.drawImage(fondo, 0, 0, Juego.ANCHO_VENTANA, Juego.ALTO_VENTANA, null);
        for (int j = 0; j < Juego.UNIDADES_ALTURA; ++j) {
            for (int i = 0; i < nivel1.getInfoNivel()[0].length; ++i) {
                int indice = nivel1.getIndice(i, j);
                g.drawImage(nivelSprites[indice], i * UNIDAD - lvlOffset, j * UNIDAD, UNIDAD, UNIDAD, null);
            }
        }
    }

    public void update() {

    }

    public Nivel getNivelActual() {
        return nivel1;
    }
}
