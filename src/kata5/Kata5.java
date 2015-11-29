package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
            
            Statement stmt = c.createStatement();
            String filename = "C:\\Users\\Juan Antonio\\Documents\\NetBeansProjects\\Kata5\\DATA\\mail.txt";
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            
            String mail;
            while ((mail = reader.readLine()) != null){
                String query = "INSERT INTO MAILS (MAIL) VALUES ('" + mail + "')";
                stmt.executeUpdate(query);
            }
            
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
