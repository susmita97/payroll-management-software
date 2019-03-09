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
public class JobDetailsFXML1Controller implements Initializable {

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
                    Logger.getLogger(JobDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JobDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(administrator.AdminViewFXMLController.setupprofileb)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JobDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JobDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JobDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
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
     
    public void save(ActionEvent event) throws SQLException
    {
        employee_id=personaldetails.PersonalDetailsFXML1Controller.employee_id;
        if (administrator.AdminViewFXMLController.insertnewrecords) 
        {
            PreparedStatement insertrecords = conn.prepareCall("insert into JOBDETAILS values((select employee_id from PERSONALDETAILS where employee_id=? ),?,?,?,?,?,?)");
            insertrecords.setString(1, employee_id);
            insertrecords.setString(2, jobtitle.getText());
            insertrecords.setString(3, jobdescription.getText());
            insertrecords.setString(4, departmentname.getText());
            insertrecords.setString(5, departmentid.getText());
            insertrecords.setString(6, qualification.getText());
            insertrecords.setString(7, notableachievements.getText());
            insertrecords.execute();
            System.out.println("Executed");
        }
        else if (administrator.AdminViewFXMLController.setupprofileb)
        {
            PreparedStatement setupprofile = conn.prepareCall("insert into JOBDETAILS values((select employee_id from PERSONALDETAILS where employee_id=? ),?,?,?,?,?,?)");
            setupprofile.setString(1, employee_id);
            setupprofile.setString(2, jobtitle.getText());
            setupprofile.setString(3, jobdescription.getText());
            setupprofile.setString(4, departmentname.getText());
            setupprofile.setString(5, departmentid.getText());
            setupprofile.setString(6, qualification.getText());
            setupprofile.setString(7, notableachievements.getText());
            setupprofile.execute();
            System.out.println("Executed");
        }
        else
        {
            PreparedStatement modifyrecords=conn.prepareCall("update JOBDETAILS set job_title=?,job_description=?,department_name=?,department_id=?,qualification=?,notable_achievements=? where employee_id=?");
            
            modifyrecords.setString(1, jobtitle.getText());
            modifyrecords.setString(2, jobdescription.getText());
            modifyrecords.setString(3, departmentname.getText());
            modifyrecords.setString(4, departmentid.getText());
            modifyrecords.setString(5, qualification.getText());
            modifyrecords.setString(6, notableachievements.getText());
            modifyrecords.setString(7, employee_id);
            modifyrecords.execute();
            System.out.println("Executed");
            
        }
    }
      
    
}
