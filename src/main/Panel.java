package main;

import inputs.InputsMouse;
import inputs.InputsTeclado;
import utilidades.ImagenURL;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Juego.*;
import static utilidades.Archivos.cargarImagen;

// Clase que se encarga de dibujar los graficos del juego en la ventana
public class Panel extends JPanel {

    private InputsMouse mouse;
    private InputsTeclado teclado;

    private BufferedImage fondo;



    // Contador de FPS
    private int frames = 0;
    private long lastCheck = System.currentTimeMillis();

    private Juego juego;

    public Panel(Juego juego) {
        mouse = new InputsMouse(this);
        teclado = new InputsTeclado(this);

        this.juego = juego;

        setTamanioPanel();

        addKeyListener(teclado);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    // Método que se encarga de darle un tamaño al panel
    private void setTamanioPanel(){
        Dimension tamanio = new Dimension(ANCHO_VENTANA, ALTO_VENTANA);
        setPreferredSize(tamanio);
        System.out.println("Tamaño del panel: " + tamanio);
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
