package DesignPattern.Adapter;

public class Main {
    public static void main(String[] args){
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        AirConditioner airConditioner = new AirConditioner();
        SocketAdapter socketAdapter = new SocketAdapter(airConditioner);
        connect(socketAdapter);

        Cleaner cleaner = new Cleaner();
        socketAdapter.setElectronic220V(cleaner);
        connect(socketAdapter);
    }

    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
