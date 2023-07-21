package utilidades;

public enum AudioURL {
    MUSICA_NIVEL_1("/audio/musica/nivel1.wav", 0),
    MUSICA_NIVEL_2("/audio/musica/nivel2.wav", 1),
    MUSICA_NIVEL_3("/audio/musica/nivel3.wav", 2),
    MUSICA_NIVEL_4("/audio/musica/nivel4.wav", 3),
    EFECTO_SALTO("/audio/efectos/salto.wav", 0);

    final String audioURL;
    final int ID;

    AudioURL(String audioURL, int ID) {
        this.audioURL = audioURL;
        this.ID = ID;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public int getID() {
        return ID;
    }
}
