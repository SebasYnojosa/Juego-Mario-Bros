package audio;

import utilidades.AudioURL;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

// Clase para escuchar musica y efectos de sonido en general en el juego
public class AudioPlayer {

    private Clip[] musica, efectos;
    private int musicaActual;
    private float volumen = 0.7f;
    private boolean musicaMuteada = false, efectosMuteados = false;
    private boolean yaPresionado = false;

    public AudioPlayer() {
        cargarMusica();
        cargarEfectos();
        iniciarMusica(AudioURL.MUSICA_NIVEL_1.getID());
    }

    private void cargarMusica() {
        musica = new Clip[5];

        musica[0] = getClip(AudioURL.MUSICA_NIVEL_1);
        musica[1] = getClip(AudioURL.MUSICA_NIVEL_2);
        musica[2] = getClip(AudioURL.MUSICA_NIVEL_3);
        musica[3] = getClip(AudioURL.MUSICA_NIVEL_4);
        musica[4] = getClip(AudioURL.MUSICA_ENDING);
    }

    private void cargarEfectos() {
        efectos = new Clip[7];

        efectos[0] = getClip(AudioURL.EFECTO_SALTO);
        efectos[1] = getClip(AudioURL.EFECTO_BOLA_FUEGO);
        efectos[2] = getClip(AudioURL.EFECTO_AGARRAR_MONEDA);
        efectos[3] = getClip(AudioURL.EFECTO_PISAR);
        efectos[4] = getClip(AudioURL.EFECTO_POWER_UP);
        efectos[5] = getClip(AudioURL.EFECTO_POWER_UP_APARECE);
        efectos[6] = getClip(AudioURL.EFECTO_MUERTE);

        setVolumenEfectos();
    }

    private Clip getClip(AudioURL audioURL) {
        URL url = getClass().getResource(audioURL.getAudioURL());
        AudioInputStream audio;

        try {
            assert url != null;
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

    public void iniciarEfecto(int efectoID) {
        efectos[efectoID].setMicrosecondPosition(0);
        efectos[efectoID].start();
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
        this.efectosMuteados = !efectosMuteados;
        for (Clip c : efectos) {
            BooleanControl controlMute = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
            controlMute.setValue(efectosMuteados);
        }
    }

    private void setVolumenMusica() {
        // Para controlar el volumen de la musica
        FloatControl controlVolumen = (FloatControl) musica[musicaActual].getControl(FloatControl.Type.MASTER_GAIN);
        float rango = controlVolumen.getMaximum()-controlVolumen.getMinimum();

        float control = (rango*volumen) + controlVolumen.getMinimum();

        controlVolumen.setValue(control);
    }

    private void setVolumenEfectos() {
        // Para controlar el volumen de los efectos
        for (Clip c: efectos){
            FloatControl controlVolumen = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
            float rango = controlVolumen.getMaximum()-controlVolumen.getMinimum();
            float control = (rango*volumen) + controlVolumen.getMinimum();
            controlVolumen.setValue(control);
        }
    }

    public boolean isYaPresionado() {
        return yaPresionado;
    }

    public void setYaPresionado(boolean yaPresionado) {
        this.yaPresionado = yaPresionado;
    }
    public boolean getMusicaMuteada(){return musicaMuteada;}
    public boolean getEfectosMuteados(){return efectosMuteados;}
}
