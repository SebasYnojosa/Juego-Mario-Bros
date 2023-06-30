package utilidades;

// Enum que contiene las direcciones de las imagenes
public enum spritesURL {
    MARIO("graficos/players/mario/marioIdle.png"),
    FONDO("graficos/fondo/fondo.png");

    final String spriteURL;

    spritesURL(String spriteURL){
        this.spriteURL = spriteURL;
    }

    public String getSpriteURL(){
        return spriteURL;
    }
}
