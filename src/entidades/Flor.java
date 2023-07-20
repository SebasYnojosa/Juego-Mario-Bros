package entidades;

import utilidades.Animaciones;

public class Flor extends Objeto{

    public Flor(float x, float y) {
        super(x, y, 1);
        this.accionActual = this.accionAnterior = Animaciones.OBJ.MOVIENDOSE_2;
        altSalir = 0;
    }

    @Override
    public void comportamiento(int[][] infoLvl) {}
}
