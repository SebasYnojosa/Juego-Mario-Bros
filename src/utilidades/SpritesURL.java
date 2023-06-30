package utilidades;

// Enum que contiene las direcciones de las imagenes
public enum SpritesURL {
    MARIO_SPRITESHEET("graficos/players/marioSprites.png"),
    FONDO("graficos/fondo/fondo.png");

    final String spriteURL;

    SpritesURL(String spriteURL){
        this.spriteURL = spriteURL;
    }

    public String getSpriteURL(){
        return spriteURL;
    }
}
