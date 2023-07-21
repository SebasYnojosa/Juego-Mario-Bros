package audio;

import utilidades.AudioURL;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

// Clase para escuchar musica y efectos de sonido en general en el juego
public class AudioPlayer {
    public static final int MUSICA_NIVEL1 = 0;
    public static final int MUSICA_NIVEL2 = 1;
    public static final int MUSICA_NIVEL3 = 2;
    public static final int MUSICA_NIVEL4 = 3;

    public static final int MUERTE = 0;
    public static final int SALTO = 1;
    public static final int GANAR = 2;
    public static final int BOLA_DE_FUEGO = 3;

    private Clip[] musica, efectos;
    private int musicaActual;
    private float volumen = 0.7f;
    private boolean musicaMuteada, efectosMuteados;

    public AudioPlayer() {
        cargarMusica();
        cargarEfectos();
        iniciarMusica(MUSICA_NIVEL1);
    }

    private void cargarMusica() {
        musica = new Clip[4];

        musica[0] = getClip(AudioURL.MUSICA_NIVEL_1);
        musica[1] = getClip(AudioURL.MUSICA_NIVEL_2);
        musica[2] = getClip(AudioURL.MUSICA_NIVEL_3);
        musica[3] = getClip(AudioURL.MUSICA_NIVEL_4);
    }

    private void cargarEfectos() {

    }

    private Clip getClip(AudioURL audioURL) {
        URL url = getClass().getResource(audioURL.getAudioURL());
        AudioInputStream audio;

        try {
            audio = AudioSystem.getAudioInputStream(url);

            Clip c = AudioSystem.getClip();
            c.open(audio);

            return c;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

    }

    public void setVolumen(float Volumen) {
        this.volumen = volumen;
        setVolumenMusica();

    }
    public void pararMusica() {
        if (musica[musicaActual].isActive())
            musica[musicaActual].stop();
    }
    public void setMusicaNivel(int nivel) {
        iniciarMusica(nivel);
    }
    private void nivelCompletado() {
        pararMusica();
    }

    public void iniciarMusica(int musicaID) {
        pararMusica();

        musicaActual = musicaID;
        setVolumenMusica();
        musica[musicaActual].setMicrosecondPosition(0);

        // Para que la cancion se repita infinitamente
        musica[musicaActual].loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void mutearMusica() {
        this.musicaMuteada = !musicaMuteada;
        for (Clip c : musica) {
            BooleanControl controlMute = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
            controlMute.setValue(musicaMuteada);
        }
    }

    public void mutearEfectos() {

    }

    private void setVolumenMusica() {
        // Para controlar el volumen de la musica
        FloatControl controlVolumen = (FloatControl) musica[musicaActual].getControl(FloatControl.Type.MASTER_GAIN);
        float rango = controlVolumen.getMaximum()-controlVolumen.getMinimum();

        float control = (rango*volumen) + controlVolumen.getMinimum();

        controlVolumen.setValue(control);
    }

    private void setVolumenEfectos() {

    }
}
