package DesignPattern.Facade;

public class FTP {

    private String host;
    private int port;
    private String path;

    public FTP(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect(){
        System.out.println("FTP Host" +host+" Port: "+ "로 연결 합니다." );
    }

    public void moveDirectory(){
        System.out.println("path: "+path+"로 이동 합니다.");

    }

    public void disConnect(){
        System.out.println("FTP 연결을 종료 합니다.");
    }
}
