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

    private HashMap<Integer, String> intToString = new HashMap<>();

    public ManejaNiveles(Juego juego) {
        this.juego = juego;
        cargarSpritesNivel();
        niveles = new ArrayList<>();
        construirNiveles();
    }

    public void armarHashMap(){
        intToString.put(1, "UNO");
        intToString.put(2, "DOS");
        intToString.put(3, "TRES");
        intToString.put(4, "CUATRO");
    }

    public String getHashValue(int key){
        return intToString.get(key);
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

    public Nivel getNivelActual() {
        return niveles.get(indexNivel);
    }

    public int getIndexNivelActual() {
        return indexNivel;
    }

    public int getCantidadNiveles(){
        return niveles.size();
    }

    public void cargarProxLvl(){    // CLAVE PARA EL CAMBIO DE BACKGROUND Y SPRITES
        indexNivel++;
        if (indexNivel >= niveles.size()){
            // MOSTRAR PANTALLA DE FIN DE JUEGO
        }

        String proxFondo;
        String proxSpritesheet;
        Nivel nuevoNivel = niveles.get(indexNivel);
        cargarSpritesNivel();
        juego.getControladorEnemigos().cargarEnemigos(nuevoNivel);
        juego.getJugador().cargarInfoNivel(nuevoNivel.getInfoNivel());
        juego.setMaxLvlOffset(nuevoNivel.getLvlOffset());
    }
}
