import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.sql.*;

public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void  run(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData pd;
            while ((pd = (PackageData) inputStream.readObject()) != null){
                    if(pd.getOperationType().equals("list")){
                        ArrayList<Students> dataBase = Server.getAllStudents();
                        PackageData response = new PackageData("list", dataBase);
                        outputStream.writeObject(response);
                    }else if (pd.getOperationType().equals("add")){
                        Students students = pd.getStudent();
                        Server.addStudent(students);
                    }
            }
        }catch(Exception e){
            e.printStackTrace();
    }

}
}
