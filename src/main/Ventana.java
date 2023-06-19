package main;

import javax.swing.*;

// Ventana principal en la cual se mostraran los graficos del juego
public class Ventana extends JFrame {
    public Ventana(Panel panel) {
        setTitle("Juego");

        // Esta funcion indica que la ventana aparecera en el medio de la pantalla
        setLocationRelativeTo(null);

        // Esta funcion indica que cuando se cierre la ventana el programa terminara
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Esta funcion combina inserta el panel en la ventana para que esta muestre su contenido
        add(panel);

        // Esta funcion hace que la ventana no se pueda cambiar de tamaño
        setResizable(false);

        // Esta funcion se encarga de que el tamaño de la ventana se ajuste al tamaño del panel
        pack();

        setVisible(true);
    }
}
