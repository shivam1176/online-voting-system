package votingManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminVoting  extends JFrame  implements ActionListener {
    JLabel l1;
    JRadioButton r1, r2;
    JButton b;

    AdminVoting() {


        l1 = new JLabel("select if you want to check result or cast vote ");
        l1.setFont(new Font("Raleway", Font.BOLD, 16));

        r1 = new JRadioButton("do you want to vote now");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("check result");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);


        ButtonGroup choice = new ButtonGroup();
        choice.add(r1);
        choice.add(r2);


        b = new JButton("submit");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);


        setLayout(null);
        l1.setBounds(140, 20, 600, 40);
        add(l1);

        r1.setBounds(100, 80, 600, 30);
        add(r1);

        r2.setBounds(100, 140, 400, 30);
        add(r2);


        b.setBounds(150, 200, 150, 30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 400);
        setLocation(500, 120);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {


        if (r1.isSelected()) {
            setVisible(false);
            new NewPole();
        }
        else if (r2.isSelected()) {

            Result r = new Result();

            System.out.println("WORKING3");
        }


    }

    public static void main(String[] args) {
        new AdminVoting();
    }
}



