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
        // Movera el personaje segun la tecla presionada
        switch (e.getKeyCode()){
            // Arriba
            case KeyEvent.VK_W:
                panel.getJuego().getJugador().setArriba(true);
                break;
            // Abajo
            case KeyEvent.VK_S:
                panel.getJuego().getJugador().setAbajo(true);
                break;
            // Izquierda
            case KeyEvent.VK_A:
                panel.getJuego().getJugador().setIzquierda(true);
                break;
            // Derecha
            case KeyEvent.VK_D:
                panel.getJuego().getJugador().setDerecha(true);
                break;
        }

        // Pondra a correr al jugador
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            panel.getJuego().getJugador().setCorriendo(true);
        }

        // El jugador se agachara
        if (e.getKeyCode() == KeyEvent.VK_C) {
            panel.getJuego().getJugador().setAgachado(true);
        }
    }

    // Se activa cuando se suelta una tecla
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                panel.getJuego().getJugador().setArriba(false);
                break;
            case KeyEvent.VK_S:
                panel.getJuego().getJugador().setAbajo(false);
                break;
            case KeyEvent.VK_A:
                panel.getJuego().getJugador().setIzquierda(false);
                break;
            case KeyEvent.VK_D:
                panel.getJuego().getJugador().setDerecha(false);
                break;
        }

        // El jugador dejara de correr
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            panel.getJuego().getJugador().setCorriendo(false);
        }

        // El jugador dejara de agacharse
        if (e.getKeyCode() == KeyEvent.VK_C) {
            panel.getJuego().getJugador().setAgachado(false);
        }
    }
}
