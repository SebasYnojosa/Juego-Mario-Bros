package main;

import inputs.InputsMouse;
import inputs.InputsTeclado;
import sprites.spritesURL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

// Clase que se encarga de dibujar los graficos del juego en la ventana
public class Panel extends JPanel {

    private InputsMouse mouse;
    private InputsTeclado teclado;
    private int xDelta = 100, yDelta = 100;
    private int xDir = 1, yDir = 1;

    // Imagen que se dibujara en el panel
    private BufferedImage marioIdle;
    private BufferedImage[] marioWalk;

    // Animaciones
    private int aniTick, aniIndice, velCambio = 30; // 30 para 4 animaciones por segundo

    public static final int UNIDAD = 32;

    // Contador de FPS
    private int frames = 0;
    private long lastCheck = System.currentTimeMillis();

    public Panel() {
        mouse = new InputsMouse(this);
        teclado = new InputsTeclado(this);

        importarImagen();

        setTamanioPanel();

        addKeyListener(teclado);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    public BufferedImage cargarImagen(String URL) throws IOException {
        return ImageIO.read(getClass().getClassLoader().getResourceAsStream(URL));
    }

    public void importarImagen() {
        try {
            marioIdle = cargarImagen(spritesURL.MARIO_IDLE.getSpriteURL());

            marioWalk = new BufferedImage[2];

            marioWalk[0] = cargarImagen(spritesURL.MARIO_WALK_1.getSpriteURL());
            marioWalk[1] = cargarImagen(spritesURL.MARIO_WALK_2.getSpriteURL());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método que se encarga de darle un tamaño al panel
    public void setTamanioPanel(){
        Dimension tamanio = new Dimension(1280, 800);
        setPreferredSize(tamanio);
    }

    /**
     * funcion que se encarga de dibujar en el panel
     * @param g objeto que controla los gráficos para luego pintarlos en el panel
     */
    public void paintComponent(Graphics g) {
        // Llamamos a la funcion paintComponent de la clase padre
        // Limpia la pantalla para luego dibujar lo que le pidamos
        super.paintComponent(g);

        updateAnimationTick();
        
        g.drawImage(marioWalk[aniIndice], xDelta, yDelta, UNIDAD, UNIDAD*2 - UNIDAD/4, null);

    }

    private void updateAnimationTick() {
        aniTick++;

        if(aniTick >= velCambio) {
            aniTick = 0;
            aniIndice++;
            if (aniIndice >= marioWalk.length)
                aniIndice = 0;
        }
    }


    public void setxDelta(int xDelta) {
        this.xDelta = xDelta;

    }

    public void setyDelta(int yDelta) {
        this.yDelta = yDelta;
    }

    public void cambiarxDelta(int valor) {
        this.xDelta += valor;
    }

    public void cambiaryDelta(int valor) {
        this.yDelta += valor;
    }

}
