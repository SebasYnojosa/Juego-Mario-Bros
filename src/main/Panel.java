package main;

import inputs.InputsMouse;
import inputs.InputsTeclado;
import utilidades.Direcciones;
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
    private int xDelta = 100, yDelta = 100;
    private int xDir = 1, yDir = 1;

    // Imagen que se dibujara en el panel
    private BufferedImage mario;
    private Direcciones jugadorDireccion = Direcciones.QUIETO;
    private boolean moviendose = false;

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

    public void importarImagen() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(spritesURL.MARIO.getSpriteURL());
        try {
            mario = ImageIO.read(is);
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

    // Funcion que se encarga de actualizar la direccion del jugador
    public void setDireccion(Direcciones direccion) {
        this.jugadorDireccion = direccion;
        moviendose = true;
    }

    // Funcion que se encarga de actualizar si el jugador se esta moviendo o no
    public void setMoviendose(boolean moviendose) {
        this.moviendose = moviendose;
    }

    private void setPosicion() {
        if (moviendose) {
            switch (jugadorDireccion) {
                case ARRIBA:
                    yDelta -= 5;
                    break;
                case DERECHA:
                    xDelta += 5;
                    break;
                case ABAJO:
                    yDelta += 5;
                    break;
                case IZQUIERDA:
                    xDelta -= 5;
                    break;
            }
        }
    }

    public void updateJuego() {
        setPosicion();
    }

    /**
     * funcion que se encarga de dibujar en el panel
     * @param g objeto que controla los gráficos para luego pintarlos en el panel
     */
    public void paintComponent(Graphics g) {
        // Llamamos a la funcion paintComponent de la clase padre
        // Limpia la pantalla para luego dibujar lo que le pidamos
        super.paintComponent(g);

        g.drawImage(mario, (int)xDelta, (int)yDelta, UNIDAD, UNIDAD + UNIDAD/2, null);
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
