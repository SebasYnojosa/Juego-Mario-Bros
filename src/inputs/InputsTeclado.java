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
            // Izquierda
            case KeyEvent.VK_A:
                panel.getJuego().getJugador().setIzquierda(true);
                break;
            // Derecha
            case KeyEvent.VK_D:
                panel.getJuego().getJugador().setDerecha(true);
                break;
            // Pondra a correr al jugador
            case KeyEvent.VK_SHIFT:
                panel.getJuego().getJugador().setCorriendo(true);
                break;
            // El jugador empezara a saltar
            case KeyEvent.VK_SPACE:
                panel.getJuego().getJugador().setSaltando(true);
                break;
        }

//        if (e.getKeyCode() == KeyEvent.VK_O) {
//            panel.getJuego().setCuadriculaActivada(!panel.getJuego().isCuadriculaActivada());
//        }
    }

    // Se activa cuando se suelta una tecla
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                panel.getJuego().getJugador().setIzquierda(false);
                break;
            case KeyEvent.VK_D:
                panel.getJuego().getJugador().setDerecha(false);
                break;
            // El jugador dejara de correr
            case KeyEvent.VK_SHIFT:
                panel.getJuego().getJugador().setCorriendo(false);
                break;
            // El jugador dejara de saltar
            case KeyEvent.VK_SPACE:
                panel.getJuego().getJugador().setSaltando(false);
                break;
        }

    }
}
