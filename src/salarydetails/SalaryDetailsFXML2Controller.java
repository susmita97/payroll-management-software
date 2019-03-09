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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class SalaryDetailsFXML2Controller implements Initializable {

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
    public double total_allowances;
    public double total_deductions;
    public double gross_salary;
    public double net_salary;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        employee_id=personaldetails.PersonalDetailsFXML1Controller.employee_id;
        employeeid.setText(employee_id);
        employeename.setText(SalaryDetailsFXML1Controller.employeenameis);
        department.setText(SalaryDetailsFXML1Controller.departmentname);
        
        total_allowances=SalaryDetailsFXML1Controller.dearnessallow+SalaryDetailsFXML1Controller.houserentallow+SalaryDetailsFXML1Controller.medicalallow+SalaryDetailsFXML1Controller.otherallow;
        total_deductions=SalaryDetailsFXML1Controller.professional_tax+SalaryDetailsFXML1Controller.tax_deducted_at_source+leavedetails.LeaveDetailsFXML1Controller.leaveamount;
        gross_salary=SalaryDetailsFXML1Controller.basic_salary+SalaryDetailsFXML1Controller.dearnessallow+SalaryDetailsFXML1Controller.houserentallow+SalaryDetailsFXML1Controller.medicalallow+SalaryDetailsFXML1Controller.otherallow+SalaryDetailsFXML1Controller.provident_fund;
        net_salary=gross_salary-total_deductions;
        
        totalallowances.setText(String.valueOf(total_allowances));
        totaltaxdeducted.setText(String.valueOf(total_deductions));
        netsalary.setText(String.valueOf(net_salary));
        grosssalary.setText(String.valueOf(gross_salary));
        
         if(administrator.AdminViewFXMLController.insertnewrecords)
            {
                try{
                if(administrator.InsertFXML1Controller.selectedvalue.equals("Administrator"))
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
                }
                if(administrator.InsertFXML1Controller.selectedvalue.equals("Chairperson"))
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CHAIRPERSON","root","susmita12");
                }
                if(administrator.InsertFXML1Controller.selectedvalue.equals("Manager"))
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/MANAGER","root","susmita12");
                }
                if(administrator.InsertFXML1Controller.selectedvalue.equals("Employee"))
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root","susmita12");
                }
                } catch (SQLException ex) {
                    Logger.getLogger(SalaryDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SalaryDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else if(administrator.AdminViewFXMLController.setupprofileb)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SalaryDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SalaryDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         else{
         try{
            if(login.LoginFXMLController.selectedvalue.equals("Administrator"))
            {
                conn=administrator.AdminViewFXML2Controller.con;
                employee_id=administrator.AdminViewFXML2Controller.employeeidis;
                getrecords();
            }
            if(login.LoginFXMLController.selectedvalue.equals("Chairperson"))
            {
                conn=chairperson.ChairpersonViewFXML2Controller.con;
                employee_id=chairperson.ChairpersonViewFXML2Controller.employeeidis;
                getrecords();
            }
            if(login.LoginFXMLController.selectedvalue.equals("Manager"))
            {
                conn=manager.ManagerViewFXML2Controller.con;
                employee_id=manager.ManagerViewFXML2Controller.employeeidis;
                getrecords();
            }
            if(login.LoginFXMLController.selectedvalue.equals("Employee"))
            {
                conn=employee.EmployeeViewFXML2Controller.con;
                employee_id=employee.EmployeeViewFXML2Controller.employeeidis;
                getrecords();
            }
          } catch (SQLException ex) {
            Logger.getLogger(SalaryDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
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
     
     
     public void save(ActionEvent event) throws SQLException
    {
        if (administrator.AdminViewFXMLController.insertnewrecords) 
        {
            PreparedStatement insertrecords = conn.prepareCall("update SALARYDETAILS set total_allowances=?,total_deductions=?,net_salary=?,gross_salary=? where employee_id=?");
            insertrecords.setDouble(1, total_allowances);
            insertrecords.setDouble(2, total_deductions);
            insertrecords.setDouble(3, net_salary);
            insertrecords.setDouble(4, gross_salary);
            insertrecords.setString(5, employee_id);
            insertrecords.execute();
            System.out.println("Executed");
        }
        else if (administrator.AdminViewFXMLController.setupprofileb)
        {
            PreparedStatement setupprofile = conn.prepareCall("update SALARYDETAILS set total_allowances=?,total_deductions=?,net_salary=?,gross_salary=? where employee_id=?");
            setupprofile.setDouble(1, total_allowances);
            setupprofile.setDouble(2, total_deductions);
            setupprofile.setDouble(3, net_salary);
            setupprofile.setDouble(4, gross_salary);
            setupprofile.setString(5, employee_id);
            setupprofile.execute();
            System.out.println("Executed");
        }
        else
        {
            PreparedStatement modifyrecords=conn.prepareCall("update SALARYDETAILS set total_allowances=?,total_deductions=?,net_salary=?,gross_salary=? where employee_id=?");
            modifyrecords.setDouble(1, total_allowances);
            modifyrecords.setDouble(2, total_deductions);
            modifyrecords.setDouble(3, net_salary);
            modifyrecords.setDouble(4, gross_salary);
            modifyrecords.setString(5, employee_id);
            modifyrecords.execute();
            System.out.println("Executed");
            
        }
    }

}
