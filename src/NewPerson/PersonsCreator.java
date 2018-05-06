package NewPerson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class PersonsCreator {

    Person person;
    String name;
    Integer age;
    TreeSet<Person> persons = new TreeSet<>();

    JButton addButton;
    JButton printPersons;
    JTextField text;
    JTextField agetext;

    public void createPerson() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel upper = new JLabel("ДОДАТИ УЧАСНИКА ЗМАГАНЬ", SwingConstants.CENTER);
        upper.setBackground(Color.gray);
        Font font = new Font ("arial", Font.BOLD, 20);
        upper.setFont(font);

        JPanel panel = new JPanel();
        JPanel panelUp = new JPanel();
        panelUp.setBackground(Color.gray);
        panelUp.add(upper);

        JLabel label = new JLabel("Ім'я:");
        JLabel agelabel = new JLabel("Вік:");

        text = new JTextField (20);
        text.addActionListener(new TextaListener());

        agetext = new JTextField(3);
        agetext.addActionListener(new TextageListener ());

        panel.setBackground(Color.gray);

        addButton = new JButton("ДОДАТИ УЧАСНИКА");
        addButton.setFont(font);
        addButton.requestFocus();
        addButton.addActionListener(new ButtonListener());

        printPersons = new JButton ("Надрукувати учасників");
        printPersons.addActionListener(new PrintListener());

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(text);
        panel.add(agelabel);
        panel.add(agetext);
        panel.add(addButton);

        frame.getContentPane().add(BorderLayout.NORTH, panelUp);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, printPersons);

        frame.setSize(500, 300);
        frame.setBackground(Color.BLUE);
        frame.setVisible(true);


    }
    class TextaListener implements ActionListener {
        public void actionPerformed (ActionEvent tex) {
            name = text.getText();
            //System.out.println(name);
            text.setText("");
            agetext.requestFocus();
        }
    }

    class TextageListener implements ActionListener {
        public void actionPerformed (ActionEvent ageev) {
            age = Integer.parseInt(agetext.getText());
           // System.out.println(age);
            agetext.setText("");
            addButton.requestFocus();
        }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
             person = new Person (name, age);
             persons.add(person);
             text.requestFocus();
        }
    }
    class PrintListener implements ActionListener {
        public void actionPerformed (ActionEvent print){
            int count = 0;
            Person.printTitle();
            for (Person p : persons) {
                count = count+1;
                System.out.println(count + " " + p.toString());
            }
        }
    }

}
