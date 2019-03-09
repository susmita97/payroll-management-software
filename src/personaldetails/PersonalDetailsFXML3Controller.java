/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaldetails;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class PersonalDetailsFXML3Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField employeeid;

    @FXML
    private JFXTextField pincode;

    @FXML
    private JFXTextField state;

    @FXML
    private JFXTextField jobtype;

    @FXML
    private JFXButton next;

    @FXML
    private JFXTextArea address;
    
    public static Connection conn;
    public static String employee_id;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
       if(login.LoginFXMLController.selectedvalue.equals("Administrator"))
            {
                conn=administrator.AdminViewFXML3Controller.con;
                employee_id=administrator.AdminViewFXML3Controller.employeeidis;
                getrecords();
            }
            if(login.LoginFXMLController.selectedvalue.equals("Chairperson"))
            {
                conn=chairperson.ChairpersonViewFXML3Controller.con;
                employee_id=chairperson.ChairpersonViewFXML3Controller.employeeidis;
                getrecords();
            }
            if(login.LoginFXMLController.selectedvalue.equals("Manager"))
            {
                conn=manager.ManagerViewFXML3Controller.con;
                employee_id=manager.ManagerViewFXML3Controller.employeeidis;
                getrecords();
            }
            if(login.LoginFXMLController.selectedvalue.equals("Employee"))
            {
                conn=employee.EmployeeViewFXML3Controller.con;
                employee_id=employee.EmployeeViewFXML3Controller.employeeidis;
                getrecords();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDetailsFXML3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void personalgui2(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("PersonalDetailsFXML4.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.setTitle("Personal Details");
       stage5.show(); 
       next.getScene().getWindow().hide();
    }
    
    public void getrecords() throws SQLException
    {
        PreparedStatement search=conn.prepareCall("select *from PERSONALDETAILS where employee_id=?");
            search.setString(1,employee_id);
            if(search.execute())
            {
                ResultSet rs=search.getResultSet();
                int i=1;
                rs.next();
                while(i<rs.getMetaData().getColumnCount())
                {
                    name.setText(rs.getString(i));
                    i++;
                    employeeid.setText(rs.getString(i));
                    i++;
                    jobtype.setText(rs.getString(i));
                    i++;
                    address.setText(rs.getString(i));
                    i++;
                    pincode.setText(rs.getString(i));
                    i++;
                    state.setText(rs.getString(i));
                    i++;
                    break;
//                    nationality.setText(rs.getString(i));
//                    i++;
//                    Date cal=rs.getDate(i);
//                    LocalDate dateis=cal.toLocalDate();
//                    dateofbirth.setValue(dateis);
//                    i++;
//                    age.setText(rs.getString(i));
//                    i++;
//                    bloodgroup.setText(rs.getString(i));
//                    i=i+2;
//                    contactno.setText(rs.getString(i));
//                    i++;
//                    emergencycontact.setText(rs.getString(i));
//                    i++;
//                    email.setText(rs.getString(i));
//                    i++;
//                    departmentname.setText(rs.getString(i));
//                    i++;
                }
                
            }
 
    }
}
