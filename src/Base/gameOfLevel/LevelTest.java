package Base.gameOfLevel;

public class LevelTest {

    public static void main(String[] args){
        Player player1 = new Player();
        player1.play();

        player1.upgradeLevel(new AdvancedLevel());
        player1.play();

        player1.upgradeLevel(new SuperLevel());
        player1.play();
    }
}
