package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputsMouse implements MouseListener, MouseMotionListener {
    // Se activa cuando se presiona un boton del mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Se hizo click en el mouse");
    }
    // Se activa cuando se mantiene apretado un boton del mouse
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Se esta apretando el mouse");
    }
    // Se activa cuando se suelta un boton del mouse
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Se solto el mouse");
    }
    // Se activa cuando el mouse entra en el panel
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("El mouse entro al panel");
    }
    // Se activa cuando el mouse sale del panel
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("El mouse salio del panel");
    }
    // Se activa cuando se mueve el mouse y se tiene un boton apretado
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Se esta arrastrando el mouse");
    }
    // Se activa cuando se mueve el mouse
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Se esta moviendo el mouse");
    }
}
