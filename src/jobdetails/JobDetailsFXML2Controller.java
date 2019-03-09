/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobdetails;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class JobDetailsFXML2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField jobtitle;

    @FXML
    private JFXTextField departmentid;

    @FXML
    private JFXTextField qualification;

    @FXML
    private JFXTextField departmentname;

    @FXML
    private JFXTextArea jobdescription;

    @FXML
    private JFXTextArea notableachievements;
    
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
            Logger.getLogger(JobDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
    
    public void getrecords() throws SQLException
    {
        PreparedStatement search=conn.prepareCall("select *from JOBDETAILS where employee_id=?");
            search.setString(1,employee_id);
            if(search.execute())
            {
                ResultSet rs=search.getResultSet();
                int i=1;
                rs.next();
                while(i<rs.getMetaData().getColumnCount())
                {
                   i++;
                   
                   jobtitle.setText(rs.getString(i));
                   i++;
                   jobdescription.setText(rs.getString(i));
                   i++;
                   departmentname.setText(rs.getString(i));
                   i++;
                   departmentid.setText(rs.getString(i));
                   i++;
                   qualification.setText(rs.getString(i));
                   i++;
                   notableachievements.setText(rs.getString(i));
                   i++;
                   break;
                }
                
            }
 
    }

}
