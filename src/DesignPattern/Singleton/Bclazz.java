package DesignPattern.Singleton;

public class Bclazz {

    private SocketClient socketClient;

    public Bclazz() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return socketClient;
    }
}
