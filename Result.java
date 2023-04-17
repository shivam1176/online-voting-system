package votingManagementsystem;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;




    public class Result {
        Result() {
//            public static void main (String[]args){

                System.out.println("WORKING");

                try {
                    System.out.println("WORKING2");
                    Conn c = new Conn();
                    HashMap hm = new HashMap<>();

                    String sql0, sql, sql1;
                    sql0 = "drop table result;";
                    sql = "create table result\n" +
                            "as\n" +
                            "select *,count(*) as num\n" +
                            "from voteto\n" +
                            "group by party1;";
                    c.s.executeUpdate(sql0);
                    c.s.executeUpdate(sql);
                    sql1 = "select * from result;";

                    ResultSet resultSet = c.s.executeQuery(sql1);
                    while (resultSet.next()) {
                        hm.put(resultSet.getString("party1"), resultSet.getInt("num"));
                    }
                    System.out.println(hm);

                } catch (Exception e) {
                    e.printStackTrace();
                }
//            }
        }
        }


