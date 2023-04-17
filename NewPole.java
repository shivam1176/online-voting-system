package votingManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPole extends JFrame  implements ActionListener {
    JLabel  l1;
    JRadioButton r1,r2,r3,r4,r5,r6;
    JButton b;
    NewPole() {


        l1 = new JLabel("choose from given options ");
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        r1 = new JRadioButton("option 1");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("option 2");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("option 3");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("option 4");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        r5 = new JRadioButton("option 5");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);

        r6 = new JRadioButton("none of above");
        r6.setFont(new Font("Raleway", Font.BOLD, 14));
        r6.setBackground(Color.WHITE);

        ButtonGroup party = new ButtonGroup();
        party.add(r1);
        party.add(r2);
        party.add(r3);
        party.add(r4);
        party.add(r5);


        b = new JButton("submit");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);


        setLayout(null);
        l1.setBounds(140, 20, 600, 40);
        add(l1);

        r1.setBounds(100, 80, 600, 30);
        add(r1);

        r2.setBounds(100, 140, 100, 30);
        add(r2);

        r3.setBounds(100, 190, 400, 30);
        add(r3);

        r4.setBounds(100, 240, 200, 30);
        add(r4);

        r5.setBounds(100, 290, 400, 30);
        add(r5);

        r6.setBounds(100, 340, 200, 30);
        add(r6);

        b.setBounds(220, 450, 150, 30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 600);
        setLocation(500, 120);
        setVisible(true);





    }
    public void actionPerformed(ActionEvent ae){

        String party1 = null;
        if (r1.isSelected()) {
            party1 = "option 1";
        } else if (r2.isSelected()) {
            party1 = "option 2";
        } else if (r3.isSelected()) {
            party1 = "option 3";
        } else if (r4.isSelected()) {
            party1 = "option 4";
        } else if (r5.isSelected()) {
            party1 = "option 5";
        }
        else if (r6.isSelected()) {
            party1 = "none of these";
        }

        try {

            if (party1 == null) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn c1 = new Conn();
               String q1 = "insert into voteto values('" + party1 + "')";
              c1.s.executeUpdate(q1);
              setVisible(false);
              new Login();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       new  NewPole();
    }
}
