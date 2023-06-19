package sprites;

// Enum que contiene las direcciones de las imagenes
public enum spritesURL {
    MARIO_IDLE("sprites/players/mario/marioIdle.png"),
    MARIO_WALK_1("sprites/players/mario/marioWalk1.png"),
    MARIO_WALK_2("sprites/players/mario/marioWalk2.png"),
    MARIO_RUN_1("sprites/players/mario/marioRun1.png"),
    MARIO_RUN_2("sprites/players/mario/marioRun2.png"),
    MARIO_RUN_3("sprites/players/mario/marioRun3.png"),
    MARIO_JUMP("sprites/players/mario/marioJump.png");

    final String spriteURL;

    spritesURL(String spriteURL){
        this.spriteURL = spriteURL;
    }

    public String getSpriteURL(){
        return spriteURL;
    }
}
