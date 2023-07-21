package niveles;

import main.Juego;
import utilidades.Archivos;
import utilidades.ImagenURL;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import static main.Juego.UNIDAD;
import static utilidades.Archivos.*;

// Clase que se encarga de manejar los niveles del juego
public class ManejaNiveles {

    private Juego juego;
    private BufferedImage[] nivelSprites;
    private ArrayList<Nivel> niveles;
    private int indexNivel = 0;

    private BufferedImage fondo;
    private BufferedImage pantallaCarga;

    private static HashMap<Integer, String> intToString = new HashMap<>();

    public ManejaNiveles(Juego juego) {
        this.juego = juego;
        cargarSpritesNivel();
        niveles = new ArrayList<>();
        construirNiveles();
        pantallaCarga = cargarImagen(ImagenURL.valueOf(getHashValue(indexNivel + 1)));
    }

    public void armarHashMap(){
        intToString.put(1, "UNO");
        intToString.put(2, "DOS");
        intToString.put(3, "TRES");
        intToString.put(4, "CUATRO");
        intToString.put(5, "ESPECIAL");
    }

    public void setPantallaCarga(){
        if (indexNivel >= 4){
            // Agregar pantalla de fin de juego
        }

        pantallaCarga = cargarImagen(ImagenURL.valueOf(getHashValue(indexNivel++)));
    }

    public String getHashValue(int key){
        return intToString.get(key);
    }

    public BufferedImage getPantallaCarga(){
        return pantallaCarga;
    }

    public void construirNiveles(){
        BufferedImage[] todoNivel = Archivos.getTodosNiveles();

        for (BufferedImage img : todoNivel){
            niveles.add(new Nivel(img));
        }
    }

    public void cargarSpritesNivel() {

        armarHashMap();
        String fondos = "FONDO_";
        String sprites = "NIVEL_";

        BufferedImage img = cargarImagen(ImagenURL.valueOf(sprites + getHashValue(indexNivel + 1)));
        nivelSprites = new BufferedImage[16*11];
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 16; i++) {
                int indice = j * 16 + i;
                nivelSprites[indice] = img.getSubimage(i * 16, j * 16, 16, 16);
            }
        }
        fondo = cargarImagen(ImagenURL.valueOf(fondos + getHashValue(indexNivel + 1)));
        intToString.clear();
        armarHashMap();
    }

    public void renderFondo(Graphics g, int lvlOffset) {
        g.drawImage(fondo, 0, 0, Juego.ANCHO_VENTANA, Juego.ALTO_VENTANA, null);
    }

    public void renderPantallaCarga(Graphics g, int lvlOffset){
        g.drawImage(pantallaCarga, 0, 0, Juego.ANCHO_VENTANA, Juego.ALTO_VENTANA, null);
    }

    public void render(Graphics g, int lvlOffset) {

        for (int j = 0; j < Juego.UNIDADES_ALTURA; ++j) {
            for (int i = 0; i < niveles.get(indexNivel).getInfoNivel()[0].length; ++i) {
                int indice = niveles.get(indexNivel).getIndice(i, j);
                g.drawImage(nivelSprites[indice], i * UNIDAD - lvlOffset, j * UNIDAD, UNIDAD, UNIDAD, null);
            }
        }
    }

    public void update() {

    }

    public void setFondo(String URL){
        fondo = cargarImagen(ImagenURL.valueOf(URL));
    }

    public Nivel getNivelActual() {
        return niveles.get(indexNivel);
    }

    public int getIndexNivelActual() {
        return indexNivel;
    }

    public int getCantidadNiveles(){
        return niveles.size();
    }

    public void cargarProxLvl(){
        indexNivel++;

        if (indexNivel >= 4)
            juego.salir(1);

        Nivel nuevoNivel = niveles.get(indexNivel);
        cargarSpritesNivel();
        juego.getControladorEnemigos().cargarEnemigos(nuevoNivel);
        juego.getControladorObj().cargarMonedas(nuevoNivel);
        juego.getControladorObj().cargarCajas(nuevoNivel);
        juego.getJugador().cargarInfoNivel(nuevoNivel.getInfoNivel());
        juego.setMaxLvlOffset(nuevoNivel.getLvlOffset());
    }
}
