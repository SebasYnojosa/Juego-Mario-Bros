package sprites;

// Enum que contiene las direcciones de las imagenes
public enum spritesURL {
    MARIO_IDLE("sprites/players/mario/marioIdle.png"),
    MARIO_WALK_1("sprites/players/mario/marioWalk1.png"),
    MARIO_WALK_2("sprites/players/mario/marioWalk2.png"),
    MARIO_RUN_1("sprites/players/mario/marioRun1.png"),
    MARIO_RUN_2("sprites/players/mario/marioRun2.png"),
    MARIO_RUN_3("sprites/players/mario/marioRun3.png"),
    MARIO_JUMP("sprites/players/mario/marioJump.png"),
    MARIO_SWIMMING_1("sprites/players/mario/marioSwimming1.png"),
    MARIO_SWIMMING_2("sprites/players/mario/marioSwimming2.png"),
    MARIO_SWIMMING_3("sprites/players/mario/marioSwimming3.png"),
    MARIO_SWIMMING_4("sprites/players/mario/marioSwimming4.png"),
    MARIO_CHARGING("sprites/players/mario/marioCharging.png"),
    MARIO_RUNNING_JUMP("sprites/players/mario/marioRunningJump.png"),
    MARIO_CROUCH("sprites/players/mario/marioCrouch.png"),
    MARIO_CLIMBING("sprites/players/mario/marioClimbing.png"),
    MARIO_KICK("sprites/players/mario/marioKick.png"),
    MARIO_PIPE("sprites/players/mario/marioPipe.png"),
    MARIO_SLIDE("sprites/players/mario/marioSlide.png"),
    MARIO_STOP("sprites/players/mario/marioStop.png"),
    MARIO_WALK_CHARGING_1("sprites/players/mario/marioWalkCharging1.png"),
    MARIO_WALK_CHARGING_2("sprites/players/mario/marioWalkCharging2.png");

    final String spriteURL;

    spritesURL(String spriteURL){
        this.spriteURL = spriteURL;
    }

    public String getSpriteURL(){
        return spriteURL;
    }
}
