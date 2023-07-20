package entidades;

import utilidades.Animaciones;

public class Hongo extends Objeto{

    public Hongo(float x, float y) {
        super(x, y, 0);
        this.accionActual = this.accionAnterior = Animaciones.OBJ.QUIETO;
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        if (estado == MOVIENDOSE){
            caminando(infoLvl);
        }
    }
}
