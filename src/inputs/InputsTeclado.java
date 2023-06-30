package inputs;

import main.Panel;
import utilidades.Direcciones;

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
        // Movera el personaje segun la tecla presionada
        switch (e.getKeyCode()){
            // Arriba
            case KeyEvent.VK_W:
                panel.setDireccion(Direcciones.ARRIBA);
                break;
            // Abajo
            case KeyEvent.VK_S:
                panel.setDireccion(Direcciones.ABAJO);
                break;
            // Izquierda
            case KeyEvent.VK_A:
                panel.setDireccion(Direcciones.IZQUIERDA);
                break;
            // Derecha
            case KeyEvent.VK_D:
                panel.setDireccion(Direcciones.DERECHA);
                break;
        }
    }

    // Se activa cuando se suelta una tecla
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
            case KeyEvent.VK_A:
            case KeyEvent.VK_D:
                panel.setMoviendose(false);
                panel.setDireccion(Direcciones.QUIETO);
                break;
        }
    }
}
