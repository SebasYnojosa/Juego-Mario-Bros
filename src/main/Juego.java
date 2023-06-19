package main;

// Clase principal del juego
public class Juego {
    private Ventana ventana;
    private Panel panel;
    public Juego() {
        panel = new Panel();
        ventana = new Ventana(panel);

        // Funcion que hace que el panel reciba los inputs del teclado o el mouse
        panel.requestFocus();
    }
}
