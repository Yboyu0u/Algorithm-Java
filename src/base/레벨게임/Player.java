package base.레벨게임;

public class Player {
    private PlayerLevel level;

    public Player() {
        this.level = new BeginnerLevel();
    }

    public PlayerLevel getLevel() {
        return level;
    }

    public void upgradeLevel(PlayerLevel playerLevel){
        this.level = playerLevel;
    }

    public void play(){
        level.go();
    }
}
