package DesignPattern.Singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    //생성자를 private으로
    private SocketClient(){

    }

    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
