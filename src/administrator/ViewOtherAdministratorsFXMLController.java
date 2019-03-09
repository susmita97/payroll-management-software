/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class ViewOtherAdministratorsFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXListView<Label> listview;
    
    @FXML
    private JFXListView<Label> listview1;
    
    @FXML
    private JFXListView<Label> listview2;
    
    @FXML
    private JFXListView<Label> listview3;
    
    @FXML
    private JFXListView<Label> listview4;
    
    
    
    public static Connection conn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
            System.out.println("Connection Established");
            PreparedStatement viewotheradmin=conn.prepareCall("select name,gender,age,contact_no,email from PERSONALDETAILS");
            viewotheradmin.execute();
            ResultSet rs=viewotheradmin.getResultSet();
            String name,gender,email;
            int age;
            double contact;
            int i=1;
            rs.next();
            while(rs.next())
            {
                while(i<=rs.getMetaData().getColumnCount())
                {
                    name=rs.getString(i);
                    Label lbl=new Label(name);
                    listview.getItems().add(lbl);
                    i++;
                    
                    gender=rs.getString(i);
                    Label lbl1=new Label(gender);
                    listview1.getItems().add(lbl1);
                    i++;
                    
                    age=rs.getInt(i);
                    String age1=String.valueOf(age);
                    Label lbl2=new Label(age1);
                    listview2.getItems().add(lbl2);
                    i++;
                    
                    //contact=rs.getDouble(i);
                    String contact1=rs.getString(i);
                    Label lbl3=new Label(contact1);
                    listview3.getItems().add(lbl3);
                    i++;
                    
                    email=rs.getString(i);
                    Label lbl4=new Label(email);
                    listview4.getItems().add(lbl4);
                    i++;
                }
                
            }
                    
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(ViewOtherAdministratorsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ViewOtherAdministratorsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
