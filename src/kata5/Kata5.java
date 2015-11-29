package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE");
            while (rs.next()){
                System.out.println("ID = " + rs.getInt("ID"));
                System.out.println("NAME = " + rs.getString("NAME"));
            }
            
            rs.close();
            stmt.close();
            c.close();
        
    }
}
