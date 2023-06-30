package main;

import inputs.InputsMouse;
import inputs.InputsTeclado;
import utilidades.spritesURL;

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

    private BufferedImage fondo;

    public static final int UNIDAD = 32;

    // Contador de FPS
    private int frames = 0;
    private long lastCheck = System.currentTimeMillis();

    private Juego juego;

    public Panel(Juego juego) {
        mouse = new InputsMouse(this);
        teclado = new InputsTeclado(this);

        this.juego = juego;

        cargarImagenes();
        setTamanioPanel();

        addKeyListener(teclado);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    private void cargarImagenes() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(spritesURL.FONDO.getSpriteURL());
        try {
            fondo = ImageIO.read(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Método que se encarga de darle un tamaño al panel
    private void setTamanioPanel(){
        Dimension tamanio = new Dimension(1280, 800);
        setPreferredSize(tamanio);
    }

    public void dibujarFondo(Graphics g) {
        g.drawImage(fondo, 0, 0, 1280, 800, null);
    }

    public void updateJuego() {

    }

    /**
     * funcion que se encarga de dibujar en el panel
     * @param g objeto que controla los gráficos para luego pintarlos en el panel
     */
    public void paintComponent(Graphics g) {
        // Llamamos a la funcion paintComponent de la clase padre
        // Limpia la pantalla para luego dibujar lo que le pidamos
        super.paintComponent(g);

        juego.render(g);
    }

    public Juego getJuego() {
        return juego;
    }

}
