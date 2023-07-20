package niveles;

import entidades.*;
import main.Juego;
import utilidades.Archivos;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilidades.Archivos.cargarImagen;

public class ControladorEnemigos {
    private Juego juego;
    private BufferedImage[][] img;
    private ArrayList<Enemigo> listaEnem = new ArrayList();

    public ControladorEnemigos(Juego juego) {
        this.juego = juego;
        cargarAnimaciones();
    }

    //Actaliza el estado de los enemigos
    public void update(int[][] infoLvl){
        for(Enemigo e: listaEnem)
            e.update(infoLvl);
    }

    public void cargarEnemigos(Nivel nivel){
        listaEnem = nivel.getEnemigo();
    }

    //Dibuja a todos los enemigos
    public void dibujar(Graphics g, int lvlOffset){
        for(Enemigo o: listaEnem){
            o.dibujar(g, lvlOffset);
            o.mostrarHitbox(g, lvlOffset);
            o.mostrarPisadobox(g, lvlOffset);
        }
    }


    //Carga las animaciones de los enemigos
    private void cargarAnimaciones() {
        BufferedImage img = cargarImagen(ImagenURL.ENEMY_GOOMBA);

        // Son 2 animaciones en total y la que tiene mas frames tiene 2
        this.img = new BufferedImage[2][2];

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                this.img[j][i] = img.getSubimage(i * 16, j * 16, 16, 16);
            }
        }
    }

    public ArrayList<Enemigo> getEnemigos(){return listaEnem;}
}
