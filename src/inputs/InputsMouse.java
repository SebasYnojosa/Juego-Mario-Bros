package inputs;

import main.Panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputsMouse implements MouseListener, MouseMotionListener {

    private Panel panel;
    public InputsMouse(Panel panel) {
        this.panel = panel;
    }

    // Se activa cuando se presiona un boton del mouse
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    // Se activa cuando se mantiene apretado un boton del mouse
    @Override
    public void mousePressed(MouseEvent e) {
    }
    // Se activa cuando se suelta un boton del mouse
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    // Se activa cuando el mouse entra en el panel
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    // Se activa cuando el mouse sale del panel
    @Override
    public void mouseExited(MouseEvent e) {
    }
    // Se activa cuando se mueve el mouse y se tiene un boton apretado
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    // Se activa cuando se mueve el mouse
    @Override
    public void mouseMoved(MouseEvent e) {
        panel.setRectPosition(e.getX(), e.getY());
    }
}
