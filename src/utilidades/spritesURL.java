package utilidades;

// Enum que contiene las direcciones de las imagenes
public enum spritesURL {
    MARIO("utilidades/players/mario/marioIdle.png");

    final String spriteURL;

    spritesURL(String spriteURL){
        this.spriteURL = spriteURL;
    }

    public String getSpriteURL(){
        return spriteURL;
    }
}
