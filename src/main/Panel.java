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
    private int xDir = 1, yDir = 1;

    // Contador de FPS
    private int frames = 0;
    private long lastCheck = System.currentTimeMillis();

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

        moverRectangulo();
        // Dibujamos un rectangulo rojo
        g.setColor(Color.RED);

        g.fillRect(xDelta,yDelta,100,100);


    }

    private void moverRectangulo() {
        xDelta += xDir;
        // Si xDelta se sale de la ventana entonces se cambia la direccion del rectangulo
        if (xDelta > 800 || xDelta < 0)
            xDir *= -1;

        yDelta += yDir;
        // Si yDelta se sale de la ventana entonces se cambia la direccion del rectangulo
        if (yDelta > 800 || yDelta < 0)
            yDir *= -1;
    }

    public void setxDelta(int value) {
        this.xDelta += value;

    }

    public void setyDelta(int value) {
        this.yDelta += value;
    }

    public void setRectPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }
}
