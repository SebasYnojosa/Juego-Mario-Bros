package niveles;

import main.Juego;
import utilidades.SpritesURL;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilidades.Archivos.cargarSprites;

// Clase que se encarga de manejar los niveles del juego
public class Niveles {

    private Juego juego;
    private BufferedImage[] spritesNivel1;
    public Niveles(Juego juego) {
        this.juego = juego;
        cargarSpritesNivel();
    }

    public void cargarSpritesNivel() {
        BufferedImage spriteSheet = cargarSprites(SpritesURL.NIVEL_CAVERNA);
        spritesNivel1 = new BufferedImage[1];

    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0,0,100,100);
    }

    public void update() {

    }
}
