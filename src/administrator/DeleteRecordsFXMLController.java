/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class DeleteRecordsFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private JFXButton personald;

    @FXML
    private JFXButton salaryd;

    @FXML
    private JFXButton jobd;

    @FXML
    private JFXButton leaved;

    @FXML
    private JFXTextField employeeid;

    @FXML
    private JFXButton deleterecords;

    @FXML
    private JFXButton searchbutton;

    @FXML
    private Label recordavailable;

    @FXML
    private JFXButton goback1;
    
    @FXML
    private JFXComboBox<String> combotype;
    public static String employeeidis;
    public static String selectedvalue;
    public static Connection conn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> list=new ArrayList<>();
    
        ObservableList<String> oblist= FXCollections.observableList(list);
        oblist.add("Administrator");
        oblist.add("Chairperson");
        oblist.add("Manager");
        oblist.add("Employee");
        combotype.setItems(oblist);
        
        
    }  
   
    
    public void searchemployeeid(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        employeeidis=employeeid.getText();
        selectedvalue=combotype.getValue();
        if(selectedvalue.equals("Administrator"))
        {
            Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
        }
        if(selectedvalue.equals("Chairperson"))
        {
           Class.forName("com.mysql.jdbc.Driver");
	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CHAIRPERSON","root","susmita12");
        }
        if(selectedvalue.equals("Manager"))
        {
            Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/MANAGER","root","susmita12");
        }
        if(selectedvalue.equals("Employee"))
        {
           Class.forName("com.mysql.jdbc.Driver");
	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root","susmita12");
        }
        
            System.out.println("Connection Established");
            PreparedStatement search=conn.prepareCall("select *from PERSONALDETAILS where employee_id=?");
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
    
     
    public void personald(ActionEvent event) throws SQLException
    {
        recordavailable.setText("");
        PreparedStatement deletep=conn.prepareCall("delete from PERSONALDETAILS where employee_id=?");
            deletep.setString(1,employeeidis);
            deletep.execute();
            System.out.println("Executed");
            recordavailable.setText("Record Deleted");
           
    }
    
    public void jobd(ActionEvent event) throws SQLException
    {
        recordavailable.setText("");
        PreparedStatement deletep=conn.prepareCall("delete from JOBDETAILS where employee_id=?");
            deletep.setString(1,employeeidis);
            deletep.execute();
            System.out.println("Executed");
            recordavailable.setText("Record Deleted");
            
    }
    
    public void salaryd(ActionEvent event) throws SQLException
    {
        recordavailable.setText("");
        PreparedStatement deletep=conn.prepareCall("delete from SALARYDETAILS where employee_id=?");
            deletep.setString(1,employeeidis);
            deletep.execute();
            System.out.println("Executed");
            recordavailable.setText("Record Deleted");
            
    }
    
    public void leaved(ActionEvent event) throws SQLException
    {
        recordavailable.setText("");
        PreparedStatement deletep=conn.prepareCall("delete from LEAVEDETAILS where employee_id=?");
            deletep.setString(1,employeeidis);
            deletep.execute();
            System.out.println("Executed");
            recordavailable.setText("Record Deleted");
            
    }
    
    public void deleteallrecords(ActionEvent event) throws SQLException
    {
        recordavailable.setText("");
        PreparedStatement deletep1=conn.prepareCall("delete from PERSONALDETAILS where employee_id=?");
        deletep1.setString(1,employeeidis);
        deletep1.execute();
        PreparedStatement deletep2=conn.prepareCall("delete from JOBDETAILS where employee_id=?");
        deletep2.setString(1,employeeidis);
        deletep2.execute();
        PreparedStatement deletep3=conn.prepareCall("delete from SALARYDETAILS where employee_id=?");
        deletep3.setString(1,employeeidis);
        deletep3.execute();
        PreparedStatement deletep4=conn.prepareCall("delete from LEAVEDETAILS where employee_id=?");
        deletep4.setString(1,employeeidis);
        
        deletep4.execute();
        System.out.println("Executed");
        recordavailable.setText("Records Deleted");
                
    }
    
    public void goback(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("AdminViewFXML.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.setTitle("Administrator Account");
       stage5.setMaximized(true);
       stage5.show(); 
       goback1.getScene().getWindow().hide();
    }
}
