package Base.gameOfLevel;

public abstract class PlayerLevel {

    abstract void run();
    abstract void jump();
    abstract void turn();
    abstract void showLevelMessage();

    final public void go(){
        showLevelMessage();
        run();
        jump();
        turn();
    }

}
