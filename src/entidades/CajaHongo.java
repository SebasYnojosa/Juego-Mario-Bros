package entidades;

public class CajaHongo extends CajaMisterio{

    public CajaHongo(float x, float y) {
        super(x, y, new Hongo(x,y));
    }
}
