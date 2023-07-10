package entidades;

import main.Juego;
import utilidades.Archivos;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilidades.Archivos.cargarImagen;

public class ControladorEnemigos {
    private Juego juego;
    private BufferedImage[][] goomba;
    private ArrayList<Goomba> listaGoombas = new ArrayList();

    public ControladorEnemigos(Juego juego) {
        this.juego = juego;
        cargarAnimaciones();
        cargarEnemigos();
    }

    //Actaliza el estado de los enemigos
    public void update(){
        for(Goomba g: listaGoombas)
            g.update();
    }

    public void cargarEnemigos(){
        listaGoombas = Archivos.getGoombas();
    }

    //Dibuja a todos los enemigos
    public void dibujar(Graphics g){
        dGoombas(g);
    }
    //Dibuja los goombas
    public void dGoombas(Graphics g){
        for(Goomba o: listaGoombas){
            g.drawImage(goomba[o.getEstado()][o.getAniIndex()], (int)o.getHitbox().x, (int)o.getHitbox().y, Juego.UNIDAD,Juego.UNIDAD,null);
            o.mostrarHitbox(g);
        }
    }


    //Carga las animaciones de los enemigos
    private void cargarAnimaciones() {
        BufferedImage img = cargarImagen(ImagenURL.ENEMY_GOOMBA);

        // Son 2 animaciones en total y la que tiene mas frames tiene 2
        goomba = new BufferedImage[2][2];

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                goomba[j][i] = img.getSubimage(i * 16, j * 16, 16, 16);
            }
        }
    }
}
