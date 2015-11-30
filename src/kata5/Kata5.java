package kata5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{           
            ArrayList<String> mailList = MailListReader.read();
            Histogram<String> histogram = MailHistogramBuilder.build(mailList);
            new HistogramDisplay(histogram).execute();
            
    }
}
