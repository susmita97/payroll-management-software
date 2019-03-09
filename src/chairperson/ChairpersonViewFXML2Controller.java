/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chairperson;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class ChairpersonViewFXML2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton goback;
     
    @FXML
    private Label recordavailable;
    
    @FXML
    private JFXButton searchbutton;
    
    @FXML
    private JFXTextField employeeid;
    
    public static String employeeidis;
    public static Connection con;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void personald(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/personaldetails/PersonalDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show();  
    }
    
    public void jobd(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/jobdetails/JobDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show();  
    }
    
    public void salaryd(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/salarydetails/SalaryDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show();  
    }
    
    public void leaved(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/leavedetails/LeaveDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show();  
    }
    
    public void goback(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("ChairpersonViewFXML.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show(); 
       goback.getScene().getWindow().hide();
    }
    
    public void searchemployeeid(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        employeeidis=employeeid.getText();
        if(ChairpersonViewFXMLController.modifyyourrecordsb)
        {
            Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CHAIRPERSON","root","susmita12");
	    System.out.println("Connection Established");
            PreparedStatement search=con.prepareCall("select *from PERSONALDETAILS where employee_id=?");
            search.setString(1,employeeidis);
            if(search.execute())
            {
                recordavailable.setText("Record Found");
            }
            else
            {
                recordavailable.setText("Record Not Found");
            }
        }
        if(ChairpersonViewFXMLController.modifymanagerb)
        {
            Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MANAGER","root","susmita12");
	    System.out.println("Connection Established");
            PreparedStatement search=con.prepareCall("select *from PERSONALDETAILS where employee_id=?");
            search.setString(1,employeeidis);
            if(search.execute())
            {
                recordavailable.setText("Record Found");
            }
            else
            {
                recordavailable.setText("Record Not Found");
            }
        }
        if(ChairpersonViewFXMLController.modifyemployeeb)
        {
            Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root","susmita12");
	    System.out.println("Connection Established");
            PreparedStatement search=con.prepareCall("select *from PERSONALDETAILS where employee_id=?");
            search.setString(1,employeeidis);
            if(search.execute())
            {
                recordavailable.setText("Record Found");
            }
            else
            {
                recordavailable.setText("Record Not Found");
            }
        }
         
        
    }
}
