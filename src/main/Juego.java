package main;

import entidades.Jugador;
import niveles.Niveles;

import java.awt.*;

// Clase principal del juego
public class Juego implements Runnable {
    private Ventana ventana;
    private Panel panel;

    private Thread hiloJuego;
    // Frames por segundo: Cuantas veces se va a dibujar la pantalla por segundo
    private final int FPS = 120;
    // Updates por segundo: Cuantas veces se va a actualizar la logica del juego por segundo
    private final int UPS = 120;

    private Jugador jugador;
    private Niveles manejaNiveles;

    public static final int UNIDAD = 32;
    public static final int UNIDADES_ANCHO = 32;
    public static final int UNIDADES_ALTURA = 20;
    public static final int ANCHO_VENTANA = UNIDADES_ANCHO * UNIDAD;
    public static final int ALTO_VENTANA = UNIDADES_ALTURA * UNIDAD;

    public Juego() {
        jugador = new Jugador(200, 200);
        manejaNiveles = new Niveles(this);
        panel = new Panel(this);
        ventana = new Ventana(panel);

        // Funcion que hace que el panel reciba los inputs del teclado o el mouse
        panel.requestFocus();

        iniciarCiclo();
    }

    private void iniciarCiclo() {
        // Creamos un hilo para que el juego se ejecute en paralelo al hilo principal
        hiloJuego = new Thread(this);
        hiloJuego.start();
    }

    // Codigo que queremos que se ejecute en el hilo principal
    public void update() {
        jugador.update();
        manejaNiveles.update();
    }

    public void render(Graphics g) {
        panel.dibujarFondo(g);
        manejaNiveles.render(g);
        jugador.render(g);
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
            if (System.currentTimeMillis() - ultimoChequeoFrames >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                ultimoChequeoFrames = System.currentTimeMillis();
            }
        }
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void jugadorSeSalioDeVentana() {
        jugador.resetDirecciones();
    }
}
