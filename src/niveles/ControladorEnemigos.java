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


    public ArrayList<Enemigo> getEnemigos(){return listaEnem;}
}
