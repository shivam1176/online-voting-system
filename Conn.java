package votingManagementsystem;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {

            c= DriverManager.getConnection("jdbc:mysql:///voting","root","Password123!");
            s =c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
