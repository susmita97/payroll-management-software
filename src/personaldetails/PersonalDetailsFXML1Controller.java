/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaldetails;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import chairperson.ChairpersonViewFXMLController;
import chairperson.ChairpersonViewFXML2Controller;
import chairperson.ChairpersonViewFXML3Controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import java.lang.String;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class PersonalDetailsFXML1Controller implements Initializable {

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
    public static String employee_name;
   
    
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
                    Logger.getLogger(PersonalDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PersonalDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if(administrator.AdminViewFXMLController.setupprofileb)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PersonalDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonalDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PersonalDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     }     
        
    }    
    
    public void personalgui2(ActionEvent event) throws IOException, SQLException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("PersonalDetailsFXML2.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.setTitle("Personal Details");
       stage5.show(); 
       next.getScene().getWindow().hide();
        
    }
    
//    public void getrecords() throws SQLException
//    {
//        PreparedStatement search=ChairpersonViewFXML2Controller.con.prepareCall("select *from PERSONALDETAILS where employee_id=?");
//        search.setString(1,ChairpersonViewFXML2Controller.employeeidis);
//        if(search.execute())
//        {
//            ResultSet rs=search.getResultSet();
//            int i=1;
//            rs.next();
//            while(i<rs.getMetaData().getColumnCount())
//            {
//                name.setText(rs.getString(i));
//                i++;
//                employeeid.setText(rs.getString(i));
//                i++;
//                jobtype.setText(rs.getString(i));
//                i++;
//                address.setText(rs.getString(i));
//                i++;
//                pincode.setText(rs.getString(i));
//                i++;
//                state.setText(rs.getString(i));
//                i++;
//                nationality.setText(rs.getString(i));
//                i++;
//                Date cal=rs.getDate(i);
//                LocalDate dateis=cal.toLocalDate();
//                dateofbirth.setValue(dateis);
//                i++;
//                age.setText(rs.getString(i));
//                i++;
//                bloodgroup.setText(rs.getString(i));
//                i=i+2;
//                contactno.setText(rs.getString(i));
//                i++;
//                emergencycontact.setText(rs.getString(i));
//                i++;
//                email.setText(rs.getString(i));
//                i++;
//                departmentname.setText(rs.getString(i));
//                i++;
//            }
//        }
//    }
    
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
    
    public void save(ActionEvent event) throws SQLException
    {
        
        if (administrator.AdminViewFXMLController.insertnewrecords) 
        {
            PreparedStatement insertrecords = conn.prepareCall("insert into PERSONALDETAILS(name,employee_id,job_type,address,pincode,state) values(?,?,?,?,?,?)");
            insertrecords.setString(1, name.getText());
            employee_name = name.getText();
            insertrecords.setString(2, employeeid.getText());
            insertrecords.setString(3, jobtype.getText());
            insertrecords.setString(4, address.getText());
            int pinc = Integer.parseInt(pincode.getText());
            insertrecords.setInt(5, pinc);
            insertrecords.setString(6, state.getText());
            insertrecords.execute();
            System.out.println("Executed");
            employee_id = employeeid.getText();
        }
        else if (administrator.AdminViewFXMLController.setupprofileb) 
        {
            PreparedStatement setupprofile = conn.prepareCall("insert into PERSONALDETAILS(name,employee_id,job_type,address,pincode,state) values(?,?,?,?,?,?)");
            setupprofile.setString(1, name.getText());
            employee_name = name.getText();
            setupprofile.setString(2, employeeid.getText());
            setupprofile.setString(3, jobtype.getText());
            setupprofile.setString(4, address.getText());
            int pinc = Integer.parseInt(pincode.getText());
            setupprofile.setInt(5, pinc);
            setupprofile.setString(6, state.getText());
            setupprofile.execute();
            System.out.println("Executed");
            employee_id = employeeid.getText();
        }
        else
        {
            PreparedStatement modifyrecords=conn.prepareCall("update PERSONALDETAILS set name=?,job_type=?,address=?,pincode=?,state=? where employee_id=?");
            modifyrecords.setString(1, name.getText());
            employee_name = name.getText();
           
            modifyrecords.setString(2, jobtype.getText());
            
            modifyrecords.setString(3, address.getText());
            
            int pinc1 = Integer.parseInt(pincode.getText());
            modifyrecords.setInt(4, pinc1);
            
            modifyrecords.setString(5, state.getText());
            
            modifyrecords.setString(6, employee_id);
            modifyrecords.execute();
            System.out.println("Executed");
            employee_id = employeeid.getText();
        }
    }
    
    public void cancel(ActionEvent event)
    {
        name.setText("");
        employeeid.setText("");
        jobtype.setText("");
        address.setText("");
        pincode.setText("");
        state.setText("");
        
                    
    }
    
    public void goback() throws IOException
    {
       
    }
   
}
