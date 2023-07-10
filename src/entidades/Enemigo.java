package entidades;

import utilidades.Animaciones;
import utilidades.ImagenURL;
public abstract class Enemigo extends Entidad{

    private int aniIndex, aniTick, aniSpeed = 12; //Variables para las animaciones
    private int estado;                //Variables de control
    private Animaciones.Enemigo accionActual = Animaciones.Enemigo.QUIETO;
    public Enemigo(float x, float y, int anchura, int altura) {
        super(x, y, anchura, altura);
        inicializarHitbox(x, y, anchura, altura);
    }

    public void update(){
        actualizarAnimacion();
    }

    public void actualizarAnimacion(){
        aniTick++;
        if(aniIndex >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            //Aqui va el sprite, ojo
            if (aniIndex >= accionActual.getCantidadDeFrames()) {
                aniIndex = 0;
            }
        }
    }

    public int getAniIndex(){
        return aniIndex;
    }
    public int getEstado(){
        return estado;
    }


}
