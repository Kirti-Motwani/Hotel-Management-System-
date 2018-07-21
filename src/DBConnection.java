
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
 /*********************************************************************************************************************************
  this method connects the database 
 *******************************************************************************************************************************/
    public static Connection connectDB(){
       try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","Kirti","Kirti108");
           //JOptionPane.showMessageDialog(null,"Connection Successfull", "Connection",JOptionPane.INFORMATION_MESSAGE);
           return conn;
           
       } catch (SQLException s) {
            JOptionPane.showMessageDialog(null,"Connection UnSuccessfull", "Connection",JOptionPane.ERROR_MESSAGE);
            return null;
       }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Some unusual error occured", "Connection",JOptionPane.ERROR_MESSAGE);
            return null;
       }
   }
    
}   
