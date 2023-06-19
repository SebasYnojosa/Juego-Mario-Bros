package main;

import inputs.InputsMouse;
import inputs.InputsTeclado;

import javax.swing.*;
import java.awt.*;

// Clase que se encarga de dibujar los graficos del juego en la ventana
public class Panel extends JPanel {

    private InputsMouse mouse;
    private InputsTeclado teclado;
    private int xDelta = 100, yDelta = 100;

    public Panel() {
        mouse = new InputsMouse(this);
        teclado = new InputsTeclado(this);

        addKeyListener(teclado);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    /**
     * funcion que se encarga de dibujar en el panel
     * @param g objeto que controla los gráficos para luego pintarlos en el panel
     */
    public void paintComponent(Graphics g) {
        // Llamamos a la funcion paintComponent de la clase padre
        // Limpia la pantalla para luego dibujar lo que le pidamos
        super.paintComponent(g);

        // Dibujamos un rectangulo rojo
        g.setColor(Color.RED);

        g.fillRect(xDelta,yDelta,100,100);
    }

    public void setxDelta(int value) {
        this.xDelta += value;
        // Llama a paintComponent cada vez que se mueve el rectangulo
        repaint();
    }

    public void setyDelta(int value) {
        this.yDelta += value;
        // Llama a paintComponent cada vez que se mueve el rectangulo
        repaint();
    }

    public void setRectPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        // Llama a paintComponent cada vez que se mueve el rectangulo
        repaint();
    }
}
