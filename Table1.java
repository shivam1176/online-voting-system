package votingManagementsystem;
import votingManagementsystem.ui.MainUi;

import  javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

public class Table1 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });

        try {
            Conn c = new Conn();


            String sql,sql1;
            sql = "create table result\n" +
                    "as\n" +
                    "select *,count(*) as num\n" +
                    "from voteto\n" +
                    "group by party1;";
            c.s.executeUpdate(sql);
            sql1 ="select * from result;";

            ResultSet resultSet =  c.s.executeQuery(sql1);
            ResultSetMetaData rsmd = resultSet.getMetaData();
//            DefaultTableModel model = ( DefaultTableModel) table1.getModel();

            int cols = rsmd.getColumnCount();
            String[] colname= new String[cols];
            for(int i =0;i<cols;i++)
            {
                colname[i]=rsmd.getColumnName(i+1);
//                model.setColumnIdentifiers(colname);

            }
            String party3,num1;
            while (resultSet.next()){
                party3=resultSet.getString(1);
                num1=resultSet.getString(2);
                String[] row ={party3,num1};
//                model.addRow(row);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createGUI(){
        MainUi ui =new MainUi();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
