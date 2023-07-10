package entidades;

import utilidades.Animaciones;
import utilidades.ImagenURL;
import utilidades.Ayuda;
public abstract class Enemigo extends Entidad{
    public static final int CAMINAR = 0, SALTAR = 1, MORIR = 2;

    private int aniIndex, aniTick, aniSpeed = 12; //Variables para las animaciones
    protected int estado = CAMINAR;               //Variables de control
    private boolean start = true, enAire = false, izq = true;         //Para cuando los update se ejecuten por primera vez

    private float velocidadAire, gravedad = 0.1f, velx = 1f; //Variables de velocidad y tal
    private Animaciones.Enemigo accionActual = Animaciones.Enemigo.QUIETO;


    public Enemigo(float x, float y, int anchura, int altura) {
        super(x, y, anchura, altura);
        inicializarHitbox(x, y, anchura, altura);
    }

    public void update(int[][] infoLvl){
        movUpdate(infoLvl);
        actualizarAnimacion();
    }

    public void movUpdate(int[][] infoLvl){
        if(start){
            if(!Ayuda.enSuelo(hitbox, infoLvl)){
                enAire = true;
            }
            start = false;
        }
        if(!enAire){
            comportamiento(infoLvl);
        }else{
            //Caer
            if(Ayuda.sePuedeMover(hitbox.x, hitbox.y+ velocidadAire, hitbox.width, hitbox.height, infoLvl)){
                hitbox.y += velocidadAire;
                velocidadAire += gravedad;
            }else{
                enAire = false;
            }
        }
    }

    public abstract void comportamiento(int[][] infoLvl);

    public void caminandoIntel(int[][] infoLvl){
        float vel = 0; //Variable de la velocidad con direccion
        if(izq){
            vel = -velx;
        }else{
            vel = velx;
        }

        if(Ayuda.sePuedeMover(hitbox.x + vel, hitbox.y, hitbox.width, hitbox.height, infoLvl)){
            if(Ayuda.eneSueloInteligente(hitbox, vel, izq,infoLvl)){
                hitbox.x += vel;
                return;
            }
        }
        if(izq){
            izq = false;
        }else{
            izq = true;
        }
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
