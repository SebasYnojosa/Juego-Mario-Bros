package main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import menus.ArchivoUsuario;
import menus.Frame1;

// Ventana principal en la cual se mostraran los graficos del juego
public class Ventana extends JFrame {
    Frame1 frame;

    public Ventana(Panel panel, Frame1 frame) {
        this.frame = frame;

        setTitle("Juego");

        // Esta funcion indica que cuando se cierre la ventana el programa terminara
        setDefaultCloseOperation(abandonoUser());

        // Esta funcion combina inserta el panel en la ventana para que esta muestre su contenido
        add(panel);

        // Esta funcion hace que la ventana no se pueda cambiar de tamaño
        setResizable(false);

        // Esta funcion se encarga de que el tamaño de la ventana se ajuste al tamaño del panel
        pack();

        // Esta funcion indica que la ventana aparecera en el medio de la pantalla
        setLocationRelativeTo(null);

        setVisible(true);

        // Esto verifica si el usuario esta en la ventana o no
        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("Soy yo, Mario!");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("Por qué te fuiste? :(");
                panel.getJuego().jugadorSeSalioDeVentana();
            }
        });
    }

    public int abandonoUser(){
        frame.getUsuario().setpAbandonadas(frame.getUsuario().getpAbandonadas() + 1);
        ArchivoUsuario arch = new ArchivoUsuario();
        arch.modificarRegistro(frame.getUsuario());
        return JFrame.EXIT_ON_CLOSE;
    }
}
