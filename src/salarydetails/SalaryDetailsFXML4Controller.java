/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarydetails;

import com.jfoenix.controls.JFXButton;
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
public class SalaryDetailsFXML4Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField employeeid;

    @FXML
    private JFXTextField employeename;

    @FXML
    private JFXTextField department;

    @FXML
    private JFXTextField grosssalary;

    @FXML
    private JFXTextField netsalary;

    @FXML
    private JFXTextField totalallowances;

    @FXML
    private JFXTextField totaltaxdeducted;

    @FXML
    private JFXButton save;

    @FXML
    private JFXButton cancel;

    @FXML
    private JFXButton exit;
    
    public static Connection conn;
    public static String employee_id;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("hi");
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
            Logger.getLogger(SalaryDetailsFXML4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
    
    public void getrecords() throws SQLException
    {
        PreparedStatement search=conn.prepareCall("select *from SALARYDETAILS where employee_id=?");
            search.setString(1,employee_id);
            if(search.execute())
            {
                ResultSet rs=search.getResultSet();
                int i=1;
                rs.next();
                while(i<rs.getMetaData().getColumnCount())
                {
                    employeeid.setText(rs.getString(i));
                    i++;
                    employeename.setText(rs.getString(i));
                    i++;
                    department.setText(rs.getString(i));
                    i++;
                   // basicsalary.setText(rs.getString(i));
                    i++;
                   // dearnessallowance.setText(rs.getString(i));
                    i++;
                   // houserentallowance.setText(rs.getString(i));
                    i++;
                   // medicalallowance.setText(rs.getString(i));
                    i++;
                   // otherallowances.setText(rs.getString(i));
                    i++;
                   // providentfund.setText(rs.getString(i));
                    i++;
                   // professionaltax.setText(rs.getString(i));
                    i++;
                   // taxdeductedatatsource.setText(rs.getString(i));
                    i++;
                    totalallowances.setText(rs.getString(i));
                    i++;
                    totaltaxdeducted.setText(rs.getString(i));
                    i++;
                    netsalary.setText(rs.getString(i));
                    i++;
                    grosssalary.setText(rs.getString(i));
                    i++;
                    break;
                }
                
            }
 
    }
}
