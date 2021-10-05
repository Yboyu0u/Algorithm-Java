package DesignPattern.Facade;

public class Main {
    public static void main(String[] args){
//        FTP ftpClient= new FTP("www.foo.co.kr",22,"/home");
//        ftpClient.connect();
//        ftpClient.moveDirectory();
//
//        Writer writer = new Writer("text.tmp");
//        writer.fileConnect();
//        writer.write();
//
//        Reader reader = new Reader("text.tmp");
//        reader.fileConnect();
//        reader.fileRead();;
//
//        reader.fileDisconnect();
//        writer.fileDisconnect();
//        ftpClient.disConnect();

        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home","text.tmp");
        sftpClient.connect();
        sftpClient.writer();
        sftpClient.read();
        sftpClient.disConnect();

    }
}
