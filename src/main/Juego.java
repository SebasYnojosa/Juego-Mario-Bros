package main;

// Clase principal del juego
public class Juego implements Runnable {
    private Ventana ventana;
    private Panel panel;

    private Thread hiloJuego;
    private final int FPS = 120;

    public Juego() {
        panel = new Panel();
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

    // Codigo que queremos que se ejecute en un hilo diferente al principal para tener un rendimiento mas consistente
    @Override
    public void run() {
        // 1 segundo = 1_000_000_000 nanosegundos
        double tiempoPorFrame = 1000000000 / FPS; // Tiempo en nanosegundos que tiene que pasar para que se ejecute un frame
        long ultimoFrame = System.nanoTime();
        long frameActual = System.nanoTime();
        int frames = 0;
        long ultimoChequeoFrames = System.currentTimeMillis();

        // Ciclo del juego que se ejecuta mientras el juego esta abierto
        while(true) {
            // Si el tiempo que paso desde el ultimo frame es mayor al tiempo que tiene que pasar para que se ejecute un frame
            frameActual = System.nanoTime();
            if (frameActual - ultimoFrame >= tiempoPorFrame){
                panel.repaint();
                ultimoFrame = System.nanoTime();
                frames++;
            }

            // Contador de FPS
            // 1 segundo = 1000 milisegundos
            if (System.currentTimeMillis() - ultimoChequeoFrames >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                ultimoChequeoFrames = System.currentTimeMillis();
            }
        }
    }
}
