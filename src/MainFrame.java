import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class MainFrame extends JFrame{
    public MenuPage menuPage;
    public ListOfStudentPage listOfStudentPage;
    public AddOfTheStudents addOfTheStudents;

    public MainFrame(){

        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Client Application");
        setResizable(false);

        addOfTheStudents = new AddOfTheStudents();
        addOfTheStudents.setLocation(0,0);
        add(addOfTheStudents);

        menuPage = new MenuPage();
        menuPage.setLocation(0,0);
        add(menuPage);


        listOfStudentPage = new ListOfStudentPage();
        listOfStudentPage.setLocation(0,0);
        add(listOfStudentPage);
        showMenuPage();

    }
    public void showMenuPage(){
        menuPage.setVisible(true);
        addOfTheStudents.setVisible(false);
        listOfStudentPage.setVisible(false);

    }

    public void showAddOfTheStudents(){
        addOfTheStudents.setVisible(true);
        menuPage.setVisible(false);
        listOfStudentPage.setVisible(false);

    }


    public void showListOfStudentPage(){
        menuPage.setVisible(false);
        addOfTheStudents.setVisible(false);
        listOfStudentPage.setVisible(true);
        listOfStudentPage.fillArea();
    }

    public void exit(){
        System.exit(0);
    }

}
