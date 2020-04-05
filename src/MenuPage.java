import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MenuPage extends Container {
    private JButton addButton;
    private JButton listButton;
    private JButton exitButton;
    public MenuPage(){
        setSize(500,500);
        setLayout(null);

        addButton = new JButton("ADD STUDENTS");
        addButton.setSize(200,30);
        addButton.setLocation(200,200);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.showAddOfTheStudents();
            }
        });
        add(addButton);


        listButton = new JButton("LIST OF STUDENTS");
        listButton.setSize(200,30);
        listButton.setLocation(200,250);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students students = new Students();
                PackageData packageData = new PackageData("list", students);
                Client.sendPackage(packageData);
                Client.frame.showListOfStudentPage();
            }
        });
        add(listButton);

        exitButton = new JButton("Exit");
        exitButton.setSize(200, 30);
        exitButton.setLocation(200, 300);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.exit();
            }
        });
        add(exitButton);
    }

}
