package utilidades;

public enum AudioURL {
    MUSICA_NIVEL_1("/audio/musica/nivel1.wav"),
    MUSICA_NIVEL_2("/audio/musica/nivel2.wav"),
    MUSICA_NIVEL_3("/audio/musica/nivel3.wav"),
    MUSICA_NIVEL_4("/audio/musica/nivel4.wav");

    final String audioURL;

    AudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public String getAudioURL() {
        return audioURL;
    }
}