package inputs;

import main.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Clase que se encarga de manejar los inputs del teclado
public class InputsTeclado implements KeyListener {

    public Panel panel;
    public InputsTeclado(Panel panel) {
        this.panel = panel;
    }

    // Se activa cuando se toca una tecla
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Se activa mientras una tecla se mantiene presionada
    @Override
    public void keyPressed(KeyEvent e) {
        // Movera el rectangulo segun la tecla que se presione
        switch (e.getKeyCode()){
            // Arriba
            case KeyEvent.VK_W:
                panel.cambiaryDelta(-10);
                break;
            // Abajo
            case KeyEvent.VK_S:
                panel.cambiaryDelta(10);
                break;
            // Izquierda
            case KeyEvent.VK_A:
                panel.cambiarxDelta(-10);
                break;
            // Derecha
            case KeyEvent.VK_D:
                panel.cambiarxDelta(10);
                break;
        }
    }

    // Se activa cuando se suelta una tecla
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
