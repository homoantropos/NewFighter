package NewPerson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Starter {
    JFrame frame;
    JButton button;

    public void go () {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton ("РОЗПОЧАТИ ЗМАГАННЯ");
        button.addActionListener(new StartListener());

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setBackground(Color.BLUE);

        frame.setSize(700, 500);
        frame.setVisible(true);
    }
    class StartListener implements ActionListener {
        public void actionPerformed (ActionEvent start) {
            PersonsCreator pcrt = new PersonsCreator();
            pcrt.createPerson();
        }

    }
}
