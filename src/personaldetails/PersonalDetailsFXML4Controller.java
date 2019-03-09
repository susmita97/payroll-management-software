/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaldetails;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class PersonalDetailsFXML4Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField nationality;

    @FXML
    private JFXTextField contactno;

    @FXML
    private JFXTextField emergencycontact;

    @FXML
    private JFXTextField bloodgroup;

    @FXML
    private JFXTextField departmentname;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXDatePicker dateofbirth;
    
    @FXML
    private JFXRadioButton male;

    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXRadioButton other;
    
    ToggleGroup group=new ToggleGroup();
    
    public static Connection conn;
    public static String employee_id;
    public static String gender;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        male.setToggleGroup(group);
        female.setToggleGroup(group);
        other.setToggleGroup(group);
        
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
            Logger.getLogger(PersonalDetailsFXML4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    //name.setText(rs.getString(i));
                    i++;
                   // employeeid.setText(rs.getString(i));
                    i++;
                   // jobtype.setText(rs.getString(i));
                    i++;
                   // address.setText(rs.getString(i));
                    i++;
                   // pincode.setText(rs.getString(i));
                    i++;
                   // state.setText(rs.getString(i));
                    i++;
                    
                    nationality.setText(rs.getString(i));
                    i++;
                    Date cal=rs.getDate(i);
                    LocalDate dateis=cal.toLocalDate();
                    dateofbirth.setValue(dateis);
                    i++;
                    age.setText(rs.getString(i));
                    i++;
                    bloodgroup.setText(rs.getString(i));
                    i++;
                    gender=rs.getString(i);
                    if(gender.equals("male"))
                    {
                        male.setSelected(true);
                    }
                    if(gender.equals("female"))
                    {
                        female.setSelected(true);
                    }
                    if(gender.equals("other"))
                    {
                        other.setSelected(true);
                    }
                    i++;
                    contactno.setText(rs.getString(i));
                    i++;
                    emergencycontact.setText(rs.getString(i));
                    i++;
                    email.setText(rs.getString(i));
                    i++;
                    departmentname.setText(rs.getString(i));
                    i++;
                    break;
    
                }
            }
    }
    
}
