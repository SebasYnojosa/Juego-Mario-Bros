package main;

import menus.NivelCompletado;
import niveles.ControladorEnemigos;
import entidades.Enemigo;
import entidades.Jugador;
import niveles.ManejaNiveles;
import utilidades.Archivos;
import utilidades.Ayuda;
import utilidades.ImagenURL;
import menus.Frame1;

import java.awt.*;

// Clase principal del juego
public class Juego implements Runnable {
    Frame1 frame;

    private Ventana ventana;
    private Panel panel;

    private Thread hiloJuego;
    // Frames por segundo: Cuantas veces se va a dibujar la pantalla por segundo
    private final int FPS = 120;
    // Updates por segundo: Cuantas veces se va a actualizar la logica del juego por segundo
    private final int UPS = 120;

    private Jugador jugador;
    private ManejaNiveles manejaNiveles;
    private ControladorEnemigos controladorEnemigos;

    private boolean cuadriculaActivada = false;

    // Manejo de niveles mas grandes

    private int xLvlOffset;
    private int bordeIzquierdo = (int) (0.4 * Juego.ANCHO_VENTANA);
    private int bordeDerecho = (int) (0.6 * Juego.ANCHO_VENTANA);
    private int maxLvlOffsetX;

    // Manejo de multiples niveles

    private boolean nivelCompletado = false;

    // Unidades basicas del juego

    public static final int UNIDAD = 32;
    public static final int UNIDADES_ANCHO = 26;
    public static final int UNIDADES_ALTURA = 14;
    public static final int ANCHO_VENTANA = UNIDADES_ANCHO * UNIDAD;
    public static final int ALTO_VENTANA = UNIDADES_ALTURA * UNIDAD;
    public static final int ALTURA_JUGADOR = 2 * UNIDAD;
    public static final int ANCHURA_JUGADOR = UNIDAD + UNIDAD/4;

    public Juego(String skin, Frame1 frame) {
        this.frame = frame;

        manejaNiveles = new ManejaNiveles(this);
        controladorEnemigos = new ControladorEnemigos(this);
        switch (skin){
            case "Mario" -> jugador = new Jugador(65, 264, ANCHURA_JUGADOR, ALTURA_JUGADOR, ImagenURL.MARIO_SPRITESHEET);
            case "Luigi" -> jugador = new Jugador(65, 264, ANCHURA_JUGADOR, ALTURA_JUGADOR, ImagenURL.LUIGI_SPRITESHEET);
            case "Peach" -> jugador = new Jugador(65, 264, ANCHURA_JUGADOR, ALTURA_JUGADOR, ImagenURL.PEACH_SPRITESHEET);
            case "Toad"  -> jugador = new Jugador(65, 264, ANCHURA_JUGADOR, ALTURA_JUGADOR, ImagenURL.TOAD_SPRITESHEET);
            default -> System.out.println("Error");
         }
        jugador.cargarInfoNivel(manejaNiveles.getNivelActual().getInfoNivel());

        panel = new Panel(this);
        ventana = new Ventana(panel, frame);
        calcularLvlOffset();
        cargarInicioNivel();

        // Funcion que hace que el panel reciba los inputs del teclado o el mouse
        panel.requestFocus();

        iniciarCiclo();
    }

    public void setMaxLvlOffset(int lvlOffset){
        this.maxLvlOffsetX = lvlOffset;
    }

    public void setNivelCompletado(boolean nivelCompletado){
        this.nivelCompletado = nivelCompletado;
    }

    public ControladorEnemigos getControladorEnemigos(){
        return controladorEnemigos;
    }

    public void calcularLvlOffset(){
        maxLvlOffsetX = manejaNiveles.getNivelActual().getLvlOffset();
    }

    public void cargarInicioNivel(){
        controladorEnemigos.cargarEnemigos(manejaNiveles.getNivelActual());
    }

    public void cargarProxNivel(){
        jugador.respawn();
        manejaNiveles.cargarProxLvl();
    }

    public void ganar(){
        if ((int) jugador.getHitbox().x == 9453){
            setNivelCompletado(true);
        }
    }

    private void iniciarCiclo() {
        // Creamos un hilo para que el juego se ejecute en paralelo al hilo principal
        hiloJuego = new Thread(this);
        hiloJuego.start();
    }

    // Codigo que queremos que se ejecute en el hilo principal
    public void update() {
        jugador.update();
//        System.out.println("JugadorPos(" + jugador.getHitbox().x + "," + jugador.getHitbox().y + ")");
        for(Enemigo e: controladorEnemigos.getEnemigos()){
            jugador.golpeado(e);
            jugador.pisar(e);
        }
        manejaNiveles.update();
        controladorEnemigos.update(manejaNiveles.getNivelActual().getInfoNivel());
        checkCloseToBorder();
        ganar();

        if (nivelCompletado == true){
            cargarProxNivel();
            nivelCompletado = false;
        }
    }

    public void checkCloseToBorder(){
        int jugadorX = (int) jugador.getHitbox().x;
        int diff = jugadorX - xLvlOffset;

        if (diff > bordeDerecho){
            xLvlOffset += diff - bordeDerecho;
        } else if (diff < bordeIzquierdo){
            xLvlOffset += diff - bordeIzquierdo;
        }

        if (xLvlOffset > maxLvlOffsetX){
            xLvlOffset = maxLvlOffsetX;
        } else if (xLvlOffset < 0){
            xLvlOffset = 0;
        }
    }

    public void render(Graphics g) {
        manejaNiveles.renderFondo(g, xLvlOffset);
        controladorEnemigos.dibujar(g, xLvlOffset);
        manejaNiveles.render(g, xLvlOffset);
        jugador.render(g, xLvlOffset);


//        if (cuadriculaActivada)
//            mostrarCuadricula(g);
    }

    // Debug cuadricula del juego
    public void mostrarCuadricula(Graphics g) {
        g.setColor(Color.BLUE);
        for (int j = 0; j < UNIDADES_ALTURA; ++j){
            for (int i = 0; i < UNIDADES_ANCHO; ++i) {
                g.drawRect(i*UNIDAD, j*UNIDAD, UNIDAD, UNIDAD);
            }
        }
    }

    // Codigo que queremos que se ejecute en un hilo diferente al principal para tener un rendimiento mas consistente
    @Override
    public void run() {
        // 1 segundo = 1_000_000_000 nanosegundos
        double tiempoPorFrame = 1000000000 / FPS; // Tiempo en nanosegundos que tiene que pasar para que se ejecute un frame
        double tiempoPorUpdate = 1000000000 / UPS; // Tiempo en nanosegundos que tiene que pasar para que se ejecute un update

        long tiempoAnterior = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long ultimoChequeoFrames = System.currentTimeMillis();

        double deltaUpdate = 0; // Tiempo que paso desde el ultimo update
        double deltaFrame = 0; // Tiempo que paso desde el ultimo update

        // Ciclo del juego que se ejecuta mientras el juego esta abierto
        while(true) {
            // Si el tiempo que paso desde el ultimo frame es mayor al tiempo que tiene que pasar para que se ejecute un frame
            long tiempoActual = System.nanoTime();

            deltaUpdate += (tiempoActual - tiempoAnterior) / tiempoPorUpdate;
            deltaFrame += (tiempoActual - tiempoAnterior) / tiempoPorFrame;
            tiempoAnterior = tiempoActual;

            if (deltaUpdate >= 1) {
                update();
                updates++;
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {
                panel.repaint();
                frames++;
                deltaFrame--;
            }

            // Contador de FPS
            // 1 segundo = 1000 milisegundos
            /*if (System.currentTimeMillis() - ultimoChequeoFrames >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                ultimoChequeoFrames = System.currentTimeMillis();
            }*/
        }
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void jugadorSeSalioDeVentana() {
        jugador.resetDirecciones();
    }

    public void setCuadriculaActivada(boolean cuadriculaActivada) {
        this.cuadriculaActivada = cuadriculaActivada;
    }

    public boolean isCuadriculaActivada() {
        return cuadriculaActivada;
    }
}
