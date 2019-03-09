/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarydetails;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
public class SalaryDetailsFXML1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label label;

    @FXML
    private JFXTextField employeeid;

    @FXML
    private JFXTextField employeename;

    @FXML
    private JFXTextField department;

    @FXML
    private JFXTextField providentfund;

    @FXML
    private JFXTextField professionaltax;

    @FXML
    private JFXTextField taxdeductedatatsource;

    @FXML
    private JFXTextField otherallowances;

    @FXML
    private JFXTextField basicsalary;

    @FXML
    private JFXTextField dearnessallowance;

    @FXML
    private JFXTextField houserentallowance;

    @FXML
    private JFXTextField medicalallowance;

    @FXML
    private JFXButton save;

    @FXML
    private JFXButton next;
    
    public static Connection conn;
    public static String employee_id;
    public static String employeenameis;
    public static String departmentname;
    public static double basic_salary;
    public static double dearnessallow;
    public static double houserentallow;
    public static double medicalallow;
    public static double otherallow;
    public static double provident_fund;
    public static double professional_tax;
    public static double tax_deducted_at_source;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         if(administrator.AdminViewFXMLController.insertnewrecords)
            {
                employee_id=personaldetails.PersonalDetailsFXML1Controller.employee_id;
                employeeid.setText(employee_id);
                employeenameis=personaldetails.PersonalDetailsFXML1Controller.employee_name;
                employeename.setText(employeenameis);
                departmentname=personaldetails.PersonalDetailsFXML2Controller.department_name;
                department.setText(departmentname);
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
                    Logger.getLogger(SalaryDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SalaryDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(administrator.AdminViewFXMLController.setupprofileb)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SalaryDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SalaryDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalaryDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }    
    
    public void salarygui2(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("SalaryDetailsFXML2.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show(); 
       next.getScene().getWindow().hide();
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
                    basicsalary.setText(rs.getString(i));
                    i++;
                    dearnessallowance.setText(rs.getString(i));
                    i++;
                    houserentallowance.setText(rs.getString(i));
                    i++;
                    medicalallowance.setText(rs.getString(i));
                    i++;
                    otherallowances.setText(rs.getString(i));
                    i++;
                    providentfund.setText(rs.getString(i));
                    i++;
                    professionaltax.setText(rs.getString(i));
                    i++;
                    taxdeductedatatsource.setText(rs.getString(i));
                    i++;
                    break;
                }
                
            }
 
    }
     
     public void save(ActionEvent event) throws SQLException
    {
        employee_id=personaldetails.PersonalDetailsFXML1Controller.employee_id;
        if (administrator.AdminViewFXMLController.insertnewrecords) 
        {
            PreparedStatement insertrecords = conn.prepareCall("insert into SALARYDETAILS(employee_id,name,department_name,basic_salary,dearness,houserent,medical,other,provident_fund,professional_tax,tax_deducted_at_source) values((select employee_id from PERSONALDETAILS where employee_id=? ),?,?,?,?,?,?,?,?,?,?)");
            insertrecords.setString(1, employee_id);

            employeenameis = employeename.getText();
            insertrecords.setString(2, employeename.getText());

            departmentname = department.getText();
            insertrecords.setString(3, department.getText());

            double basicsal = Double.parseDouble(basicsalary.getText());
            insertrecords.setDouble(4, basicsal);
            basic_salary = basicsal;

            double dearness = Double.parseDouble(dearnessallowance.getText());
            insertrecords.setDouble(5, dearness);
            dearnessallow = dearness;

            double houserent = Double.parseDouble(houserentallowance.getText());
            insertrecords.setDouble(6, houserent);
            houserentallow = houserent;

            double medical = Double.parseDouble(medicalallowance.getText());
            insertrecords.setDouble(7, medical);
            medicalallow = medical;

            double other = Double.parseDouble(otherallowances.getText());
            insertrecords.setDouble(8, other);
            otherallow = other;

            double provident = Double.parseDouble(providentfund.getText());
            insertrecords.setDouble(9, provident);
            provident_fund = provident;

            double professional = Double.parseDouble(professionaltax.getText());
            insertrecords.setDouble(10, professional);
            professional_tax = professional;

            double taxdeducted = Double.parseDouble(taxdeductedatatsource.getText());
            insertrecords.setDouble(11, taxdeducted);
            tax_deducted_at_source = taxdeducted;

            insertrecords.execute();
            System.out.println("Executed");
        }
        else if (administrator.AdminViewFXMLController.setupprofileb)
        {
            PreparedStatement setupprofile = conn.prepareCall("insert into SALARYDETAILS(employee_id,name,department_name,basic_salary,dearness,houserent,medical,other,provident_fund,professional_tax,tax_deducted_at_source) values((select employee_id from PERSONALDETAILS where employee_id=? ),?,?,?,?,?,?,?,?,?,?)");
            setupprofile.setString(1, employee_id);

            employeenameis = employeename.getText();
            setupprofile.setString(2, employeename.getText());

            departmentname = department.getText();
            setupprofile.setString(3, department.getText());

            double basicsal = Double.parseDouble(basicsalary.getText());
            setupprofile.setDouble(4, basicsal);
            basic_salary = basicsal;

            double dearness = Double.parseDouble(dearnessallowance.getText());
            setupprofile.setDouble(5, dearness);
            dearnessallow = dearness;

            double houserent = Double.parseDouble(houserentallowance.getText());
            setupprofile.setDouble(6, houserent);
            houserentallow = houserent;

            double medical = Double.parseDouble(medicalallowance.getText());
            setupprofile.setDouble(7, medical);
            medicalallow = medical;

            double other = Double.parseDouble(otherallowances.getText());
            setupprofile.setDouble(8, other);
            otherallow = other;

            double provident = Double.parseDouble(providentfund.getText());
            setupprofile.setDouble(9, provident);
            provident_fund = provident;

            double professional = Double.parseDouble(professionaltax.getText());
            setupprofile.setDouble(10, professional);
            professional_tax = professional;

            double taxdeducted = Double.parseDouble(taxdeductedatatsource.getText());
            setupprofile.setDouble(11, taxdeducted);
            tax_deducted_at_source = taxdeducted;

            setupprofile.execute();
            System.out.println("Executed");
        }
        else
        {
            PreparedStatement modifyrecords=conn.prepareCall("update SALARYDETAILS set basic_salary=?,dearness=?,houserent=?,medical=?,other=?,provident_fund=?,professional_tax=?,tax_deducted_at_source=? where employee_id=?");
            

            
            double basicsal = Double.parseDouble(basicsalary.getText());
            modifyrecords.setDouble(1, basicsal);
            basic_salary = basicsal;

            double dearness = Double.parseDouble(dearnessallowance.getText());
            modifyrecords.setDouble(2, dearness);
            dearnessallow = dearness;

            double houserent = Double.parseDouble(houserentallowance.getText());
            modifyrecords.setDouble(3, houserent);
            houserentallow = houserent;

            double medical = Double.parseDouble(medicalallowance.getText());
            modifyrecords.setDouble(4, medical);
            medicalallow = medical;

            double other = Double.parseDouble(otherallowances.getText());
            modifyrecords.setDouble(5, other);
            otherallow = other;

            double provident = Double.parseDouble(providentfund.getText());
            modifyrecords.setDouble(6, provident);
            provident_fund = provident;

            double professional = Double.parseDouble(professionaltax.getText());
            modifyrecords.setDouble(7, professional);
            professional_tax = professional;

            double taxdeducted = Double.parseDouble(taxdeductedatatsource.getText());
            modifyrecords.setDouble(8, taxdeducted);
            tax_deducted_at_source = taxdeducted;
            
            modifyrecords.setString(9, employee_id);

            modifyrecords.execute();
            System.out.println("Executed");

        }
        
    }

}
