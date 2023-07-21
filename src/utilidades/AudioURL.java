package utilidades;

public enum AudioURL {
    MUSICA_NIVEL_1("/audio/musica/nivel1.wav", 0),
    MUSICA_NIVEL_2("/audio/musica/nivel2.wav", 1),
    MUSICA_NIVEL_3("/audio/musica/nivel3.wav", 2),
    MUSICA_NIVEL_4("/audio/musica/nivel4.wav", 3),
//    MUSICA_ENDING("/audio/musica/ending.wav", 4),
    EFECTO_SALTO("/audio/efectos/salto.wav", 0),
    EFECTO_BOLA_FUEGO("/audio/efectos/fuego.wav", 1),
    EFECTO_AGARRAR_MONEDA("/audio/efectos/moneda.wav", 2),
    EFECTO_PISAR("/audio/efectos/pisar.wav", 3),
    EFECTO_POWER_UP("/audio/efectos/powerUp.wav", 4),
    EFECTO_POWER_UP_APARECE("/audio/efectos/powerUpAparece.wav", 5);

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
