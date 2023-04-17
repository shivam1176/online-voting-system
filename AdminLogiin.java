package votingManagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Arrays;


public class AdminLogiin extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField tf1;
    JTextField pf2;

    JButton b1,b2;

   AdminLogiin(){
        setLayout(null);
        l1 = new JLabel("Admin login page");
        l1.setFont(new Font("Osward", Font.BOLD, 44));
        l1.setBounds(200,40,700,40);
        add(l1);

        l2 = new JLabel("user name ");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        l3 = new JLabel("password ");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);

        pf2 = new JTextField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);

        b1 = new JButton("login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);


        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        add(b2);



        b1.addActionListener(this);
        b2.addActionListener(this);


        setTitle("online voting system ");
        setSize(1000, 480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2) {
            tf1.setText("");
            pf2.setText("");
        }
        else if(ae.getSource()==b1){
            String username = tf1.getText();
            String password = pf2.getText();
            String query ="select * from login where username='"+username+"' and password='"+password+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new AdminVoting();
                }else{
                    JOptionPane.showMessageDialog(null,"invalid username or password");
                    setVisible(false);

                }

            }catch(Exception e){
                e.printStackTrace();
            }


        }

    }
    public static void main(String[] args) {
        new AdminLogiin();


    }


}
