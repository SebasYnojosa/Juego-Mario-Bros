package entidades;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entidad {
    protected float x, y;
    protected int anchura, altura;
    protected Rectangle2D.Float hitbox;

    public Entidad(float x, float y, int anchura, int altura) {
        this.x = x;
        this.y = y;
        this.anchura = anchura;
        this.altura = altura;
    }

    protected void mostrarHitbox(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
    }

    protected void inicializarHitbox(float x, float y, float anchura, float altura) {
        hitbox = new Rectangle2D.Float(x, y, anchura, altura);
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }
}
