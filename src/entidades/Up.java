package entidades;

import utilidades.Animaciones;

public class Up extends Objeto{
    public Up(float x, float y) {
        super(x, y, 3);
        this.accionActual = this.accionAnterior = Animaciones.OBJ.QUIETO;
        altSalir = 2;
    }

    @Override
    public void comportamiento(int[][] infoLvl) {
        if(estado == MOVIENDOSE){
            caminando(infoLvl);
        }
    }
}
