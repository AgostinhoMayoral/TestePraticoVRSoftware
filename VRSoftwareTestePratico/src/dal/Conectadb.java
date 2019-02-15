/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author tinho
 */
public class Conectadb {
    
    public static Connection conectadb() throws ClassNotFoundException{
        
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_faculdade","postgres","root");
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            return con;
        }
        catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, "error");
            
            return null;
        }
        
    }
}
