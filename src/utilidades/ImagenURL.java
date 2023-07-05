package utilidades;

// Enum que contiene las direcciones de las imagenes
public enum ImagenURL {
    MARIO_SPRITESHEET("graficos/players/marioSprites.png"),
    FONDO("graficos/fondo/fondo.png"),
    NIVEL_CAVERNA("graficos/niveles/caverna.png"),
    NIVEL_SUPERFICIE("graficos/niveles/superficie.png"),
    INFO_NIVEL_UNO("niveles/level_one_data.png");

    final String spriteURL;

    ImagenURL(String spriteURL){
        this.spriteURL = spriteURL;
    }

    public String getSpriteURL(){
        return spriteURL;
    }
}
