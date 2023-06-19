package main;

import inputs.InputsMouse;
import inputs.InputsTeclado;

import javax.swing.*;
import java.awt.*;

// Clase que se encarga de dibujar los graficos del juego en la ventana
public class Panel extends JPanel {

    private InputsMouse mouse;
    public Panel() {
        mouse = new InputsMouse();

        addKeyListener(new InputsTeclado());
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

        g.fillRect(0,0,100,100);
    }
}
