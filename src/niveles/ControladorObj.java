package niveles;

import entidades.Enemigo;
import main.Juego;
import utilidades.Archivos;
import utilidades.ImagenURL;

import entidades.*;
import main.Juego;
import static utilidades.Archivos.*;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ControladorObj {
    private Juego juego;
    private BufferedImage[][] img;
    private ArrayList<CajaMisterio> listaCaja = new ArrayList();

    public ControladorObj(Juego juego) {
        this.juego = juego;
    }

    //Actaliza el estado de los Objetos
    public void update(int[][] infoLvl){
        for(CajaMisterio o: listaCaja)
            o.update(infoLvl);
    }
    public void cargarCajas(Nivel nivel){
        listaCaja = nivel.getListaCajas();
    }

    //Dibuja a todos los enemigos
    public void dibujar(Graphics g, int lvlOffset){
        for(CajaMisterio o: listaCaja){
            o.obj.dibujar(g, lvlOffset);
            o.dibujar(g, lvlOffset);
            o.mostrarHitbox(g, lvlOffset);
        }
    }



    public ArrayList<CajaMisterio> getCajas(){return listaCaja;}
}
