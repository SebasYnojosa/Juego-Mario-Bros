package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Clase que se encarga de manejar los inputs del teclado
public class InputsTeclado implements KeyListener {
    // Se activa cuando se toca una tecla
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Tecla tocada: " + e.getKeyChar());
    }

    // Se activa mientras una tecla se mantiene presionada
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla presionada: " + e.getKeyChar());
    }

    // Se activa cuando se suelta una tecla
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tecla soltada: " + e.getKeyChar());
    }
}
