package entidades;

import main.Juego;
import utilidades.Animaciones;
import utilidades.ImagenURL;
import utilidades.Ayuda;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static utilidades.Archivos.cargarImagen;

public abstract class Enemigo extends Entidad{
    //Estados para la IA
    public static final int CAMINAR = 0, SALTAR = 1, MORIR = 2;
    //Animaciones
    private BufferedImage[][] animaciones;
    private Animaciones.Enemigo accionAnterior = Animaciones.Enemigo.CAMINANDO;
    protected Animaciones.Enemigo accionActual = Animaciones.Enemigo.CAMINANDO;
    private int aniIndex, aniTick, aniSpeed = 12;

    //Comportamientos
    protected int estado = CAMINAR;               //Variables de control
    private boolean start = true, enAire = false, izq = true;         //Para cuando los update se ejecuten por primera vez

    private float velocidadAire, gravedad = 0.1f, velx = 1f; //Variables de velocidad y tal
    protected Rectangle2D.Float pisadoBox;


    public Enemigo(float x, float y, int anchura, int altura, ImagenURL imagenURL) {
        super(x, y, anchura, altura);
        inicializarHitbox(x, y, anchura, altura);
        inicializarPisadobox(x, y, anchura, altura);
        cargarAnimaciones(imagenURL);
    }

    // <editor-fold defaultstate="collapsed" desc="ACTUALIZACIONES DE FRAME">//GEN-BEGIN:initComponents
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
                pisadoBox.y += velocidadAire;
                velocidadAire += gravedad;
            }else{
                enAire = false;
            }
        }
    }

    // </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="COMPORTAMIENTOS GENERALES">//GEN-BEGIN:initComponents
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
                pisadoBox.x += vel;
                return;
            }
        }
        if(izq){
            izq = false;
        }else{
            izq = true;
        }
    }

    public void caminando(int[][] infoLvl){
        float vel = 0; //Variable de la velocidad con direccion
        if(izq){
            vel = -velx;
        }else{
            vel = velx;
        }

        if(Ayuda.sePuedeMover(hitbox.x, hitbox.y+ velocidadAire, hitbox.width, hitbox.height, infoLvl)){
            enAire = true;
        }

        if(Ayuda.sePuedeMover(hitbox.x + vel, hitbox.y, hitbox.width, hitbox.height, infoLvl)){
                hitbox.x += vel;
                pisadoBox.x += vel;
                return;
        }
        if(izq){
            izq = false;
        }else{
            izq = true;
        }
    }

    public abstract void morir();

    // </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="ANIMACIONES">//GEN-BEGIN:initComponents

    public void dibujar(Graphics g, int lvlOffset){
        if(izq)
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-Goomba.handicap - lvlOffset, (int)getHitbox().y-(Goomba.handicap+(Juego.UNIDAD/2)), Juego.UNIDAD,Juego.UNIDAD,null);
        else
            g.drawImage(animaciones[estado][aniIndex], (int)getHitbox().x-Goomba.handicap + Juego.UNIDAD - lvlOffset, (int)getHitbox().y-(Goomba.handicap+(Juego.UNIDAD/2)), -Juego.UNIDAD,Juego.UNIDAD,null);
    }
    private void cargarAnimaciones(ImagenURL imagenURL) {
        BufferedImage imagenes = cargarImagen(imagenURL);

        // Son 3 animaciones en total y la que tiene mas frames tiene 2
        animaciones = new BufferedImage[3][2];

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 2; i++) {
                animaciones[j][i] = imagenes.getSubimage(i * 16, j * 16, 16, 16);
            }
        }
    }
    public void actualizarAnimacion(){
        // Si la accion actual es diferente a la accion anterior, se reinicia el indice
        // Esto para evitar parpadeos en el cambio de animaciones
        if (accionActual != accionAnterior) {
            aniIndex = 0;
            accionAnterior = accionActual;
        }
        
        aniTick++;
        if(aniTick >= aniSpeed){
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
    public void setEstado(int estado){
        this.estado = estado;
    }
    // </editor-fold>//GEN-END:initComponents

    public void setAccionActual(Animaciones.Enemigo est){
        this.accionActual = est;
    }
    public abstract void comportamiento(int[][] infoLvl);

    // <editor-fold defaultstate="collapsed" desc="PISADOBOX">//GEN-BEGIN:initComponents
    public void mostrarPisadobox(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawRect((int)pisadoBox.x, (int)pisadoBox.y, (int)pisadoBox.width, (int)pisadoBox.height);
    }

    protected void inicializarPisadobox(float x, float y, float anchura, float altura) {
        pisadoBox = new Rectangle2D.Float(x, y-(Juego.UNIDAD/2), anchura, altura);
    }

    public Rectangle2D.Float getPisadoBox() {
        return pisadoBox;
    }
    // </editor-fold>//GEN-END:initComponents
}
