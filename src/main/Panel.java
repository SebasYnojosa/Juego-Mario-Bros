package main;

import javax.swing.*;
import java.awt.*;

// Clase que se encarga de dibujar los graficos del juego en la ventana
public class Panel extends JPanel {
    public Panel() {

    }

    /**
     * funcion que se encarga de dibujar en el panel
     * @param g objeto que controla los gráficos para luego pintarlos en el panel
     */
    public void paintComponent(Graphics g) {
        // Llamamos a la funcion paintComponent de la clase padre
        // Limpia la pantalla para luego dibujar lo que le pidamos
        super.paintComponent(g);

        // Hace que todos los pixeles que dibujemos sean del color indicado
        g.setColor(Color.RED);

        // Dibujamos un rectangulo
        g.fillRect(0, 0, 100, 20);

        // Color piel
        g.setColor(new Color(243, 168, 168));

        g.fillRect(0, 20, 100, 60);

        g.setColor(Color.BLUE);

        g.fillRect(0, 70, 100, 80);

        // Color Marrón
        g.setColor(new Color(128, 64, 0));

        g.fillRect(0, 150, 100, 50);
    }
}
