package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailListReader {
    public static ArrayList<String> read () throws SQLException, ClassNotFoundException{
        ArrayList<String> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:KATADB");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT mail FROM MAILS");
        
        while (rs.next()){
            String mail = rs.getString("mail");
            if (!mail.contains("@")){
                continue;
            }
            mailList.add(mail);
        }
        return mailList;
    }
}
