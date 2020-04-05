import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;

public class ListOfStudentPage  extends Container{
    private JButton back;
    private JLabel id;
    private JTextArea area;
    private JTable table;
    private String columnNames[] = {"id", "name", "surname", "age"};
    public ListOfStudentPage(){
        setSize(500,500);
        setLayout(null);

        id = new JLabel("ID");
        id.setSize(100, 30);
        id.setLocation(70, 10);
        add(id);
        id = new JLabel("NAME");
        id.setSize(100, 30);
        id.setLocation(140, 10);
        add(id);
        id = new JLabel("SURNAME");
        id.setSize(100, 30);
        id.setLocation(210, 10);
        add(id);
        id = new JLabel("AGE");
        id.setSize(100, 30);
        id.setLocation(300, 10);
        add(id);

        back = new JButton("BACK");
        back.setSize(200,30);
        back.setLocation(250,450);
        add(back);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Client.frame.showMenuPage();
            }
        });
    }

    public void fillArea(){
        PackageData response = Client.getPackage();
        ArrayList<Students> students = response.getStudents();
        Object values[][] = new Object[students.size()][4];
        for (int i = 0; i < students.size(); i++){
            values[i][0] =students.get(i).getId();
            values[i][1] = students.get(i).getName();
            values[i][2] = students.get(i).getSurname();
            values[i][3] = students.get(i).getAge();
        }

        table = new JTable(values, columnNames);
        table.setSize(500,500);
        table.setLocation(50,50);

        add(table);
    }
}
