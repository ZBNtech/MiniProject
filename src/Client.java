import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.*;

public class Client {
    public static MainFrame frame;
    public static Socket socket;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;

    public static void main(String[] args) {
        connectToServer("127.0.0.1",198);
        frame = new MainFrame();
        frame.setVisible(true);
    }


    public static void connectToServer(String ip, int port){
        boolean check = false;
        try{
            socket = new Socket(ip, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            check = true;
        }catch(Exception e){
            e.printStackTrace();
            check = false;
        }
    }

    public static void sendPackage(PackageData pack){
        try{
            outputStream.writeObject(pack);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static PackageData getPackage(){
        PackageData pd= new PackageData();
        try{
            pd = (PackageData)inputStream.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return pd;
    }
}

