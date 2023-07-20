package utilidades;

// Enum que contiene las direcciones de las imagenes
public enum ImagenURL {
    MARIO_SPRITESHEET("graficos/players/marioSprites.png"),
    LUIGI_SPRITESHEET("graficos/players/luigiSprites.png"),
    PEACH_SPRITESHEET("graficos/players/peachSprites.png"),
    TOAD_SPRITESHEET("graficos/players/toadSprites.png"),
    FONDO("graficos/fondo/fondo.png"),
    FONDO_CAVERNA("graficos/fondo/fondoCaverna.png"),
    FONDO_HIELO("graficos/fondo/fondoHielo.png"),
    FONDO_CASTILLO("graficos/fondo/fondoCastillo.png"),
    NIVEL_CAVERNA("graficos/niveles/cavernaGravilla.png"),
    NIVEL_SUPERFICIE("graficos/niveles/superficie.png"),
    NIVEL_HIELO("graficos/niveles/superficieHielo.png"),
    NIVEL_CASTILLO("graficos/niveles/castillo.png"),
    INFO_NIVEL_UNO("niveles/level_one_data.png"),
    INFO_NIVEL_CAVERNA("niveles/level_caverna_data.png"),
    INFO_NIVEL_HIELO("niveles/level_hielo_data.png"),
    INFO_NIVEL_CASTILLO("niveles/level_castillo_data.png"),
    ENEMY_GOOMBA("graficos/enemigos/goombaSprites.png"),
    ENEMY_KOOPAVERDE("graficos/enemigos/koopaVerdeSprites.png"),
    ENEMY_KOOPAROJO("graficos/enemigos/koopaRojoSprites.png"),
    ENEMY_SPINY("graficos/enemigos/spinyCavernaSprites.png"),
    ENEMY_SKURRY("graficos/enemigos/escarabajoBuzzySprites.png"),
    ENEMY_PIRA("graficos/enemigos/piranhaSprites.png");

    final String spriteURL;

    ImagenURL(String spriteURL){
        this.spriteURL = spriteURL;
    }

    public String getSpriteURL(){
        return spriteURL;
    }
}
