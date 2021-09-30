package DesignPattern.Singleton;

public class Main {

    public static void main(String[] args){
        Aclazz aClazz = new Aclazz();
        Bclazz bclazz = new Bclazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bclazz.getSocketClient();

        System.out.println(aClient.equals(bClient));
    }
}

