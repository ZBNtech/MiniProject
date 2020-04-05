import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Server {
    public static ArrayList<Students> students = new ArrayList<Students>();
    public static Connection connection;

    public static void disconnect(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/university?useUnicode=true&serverTimezone=UTC", "root", "");
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ServerSocket serverSocket = new ServerSocket(198);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
    }



    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                list.add(new Students(id, name, surname, age));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void addStudent(Students student){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students(id, name, surname, age)" + "VALUES(NULL, ?, ?, ?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

