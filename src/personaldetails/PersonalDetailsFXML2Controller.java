/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaldetails;

import chairperson.ChairpersonViewFXML2Controller;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class PersonalDetailsFXML2Controller implements Initializable {

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
    public static String department_name;
    public static String gender;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        male.setToggleGroup(group);
        female.setToggleGroup(group);
        other.setToggleGroup(group);
        
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
                    Logger.getLogger(PersonalDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PersonalDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(administrator.AdminViewFXMLController.setupprofileb)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PersonalDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonalDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            else{
             try {
                 if (login.LoginFXMLController.selectedvalue.equals("Administrator")) {
                     conn = administrator.AdminViewFXML2Controller.con;
                     employee_id = administrator.AdminViewFXML2Controller.employeeidis;
                     getrecords();
                 }
                 if (login.LoginFXMLController.selectedvalue.equals("Chairperson")) {
                     conn = chairperson.ChairpersonViewFXML2Controller.con;
                     employee_id = chairperson.ChairpersonViewFXML2Controller.employeeidis;
                     getrecords();
                 }
                 if (login.LoginFXMLController.selectedvalue.equals("Manager")) {
                     conn = manager.ManagerViewFXML2Controller.con;
                     employee_id = manager.ManagerViewFXML2Controller.employeeidis;
                     getrecords();
                 }
                 if (login.LoginFXMLController.selectedvalue.equals("Employee")) {
                     conn = employee.EmployeeViewFXML2Controller.con;
                     employee_id = employee.EmployeeViewFXML2Controller.employeeidis;
                     getrecords();
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(PersonalDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
             }
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
    
    public void save(ActionEvent event) throws SQLException
    {
         employee_id=PersonalDetailsFXML1Controller.employee_id;
         if(male.isSelected())
         {
             gender="male";
         }
         if(female.isSelected())
         {
             gender="female";
         }
         if(other.isSelected())
         {
             gender="other";
         }
         if (administrator.AdminViewFXMLController.insertnewrecords) 
         {
            PreparedStatement insertrecords = conn.prepareCall("update PERSONALDETAILS set nationality=?,date_of_birth=?,age=?,blood_group=?,gender=?,contact_no=?,emergency_contact_no=?,email=?,department_name=? where employee_id=?");
            insertrecords.setString(1, nationality.getText());

            LocalDate dateofb = dateofbirth.getValue();
            Date dateis = Date.valueOf(dateofb);
            insertrecords.setDate(2, dateis);

            int ageis = Integer.parseInt(age.getText());
            insertrecords.setInt(3, ageis);

            insertrecords.setString(4, bloodgroup.getText());
            
            insertrecords.setString(5, gender);
            
            double contact = Double.parseDouble(contactno.getText());
            insertrecords.setDouble(6, contact);

            double emercontact = Double.parseDouble(emergencycontact.getText());
            insertrecords.setDouble(7, emercontact);

            insertrecords.setString(8, email.getText());

            insertrecords.setString(9, departmentname.getText());
            department_name = departmentname.getText();

            insertrecords.setString(10, employee_id);
            insertrecords.execute();
            System.out.println("Executed");
        }
        
        else if (administrator.AdminViewFXMLController.setupprofileb)
        {
            PreparedStatement insertrecords = conn.prepareCall("update PERSONALDETAILS set nationality=?,date_of_birth=?,age=?,blood_group=?,gender=?,contact_no=?,emergency_contact_no=?,email=?,department_name=? where employee_id=?");
            insertrecords.setString(1, nationality.getText());

            LocalDate dateofb = dateofbirth.getValue();
            Date dateis = Date.valueOf(dateofb);
            insertrecords.setDate(2, dateis);

            int ageis = Integer.parseInt(age.getText());
            insertrecords.setInt(3, ageis);

            insertrecords.setString(4, bloodgroup.getText());
            
            insertrecords.setString(5, gender);
            
            double contact = Double.parseDouble(contactno.getText());
            insertrecords.setDouble(6, contact);

            double emercontact = Double.parseDouble(emergencycontact.getText());
            insertrecords.setDouble(7, emercontact);

            insertrecords.setString(8, email.getText());

            insertrecords.setString(9, departmentname.getText());
            department_name = departmentname.getText();

            insertrecords.setString(10, employee_id);
            insertrecords.execute();
            System.out.println("Executed");
        }
         
         else
         {
            PreparedStatement setupprofile = conn.prepareCall("update PERSONALDETAILS set nationality=?,date_of_birth=?,age=?,blood_group=?,gender=?,contact_no=?,emergency_contact_no=?,email=?,department_name=? where employee_id=?");
            setupprofile.setString(1, nationality.getText());

            LocalDate dateofb = dateofbirth.getValue();
            Date dateis = Date.valueOf(dateofb);
            setupprofile.setDate(2, dateis);

            int ageis = Integer.parseInt(age.getText());
            setupprofile.setInt(3, ageis);

            setupprofile.setString(4, bloodgroup.getText());
            
            setupprofile.setString(5, gender);

            double contact = Double.parseDouble(contactno.getText());
            setupprofile.setDouble(6, contact);

            double emercontact = Double.parseDouble(emergencycontact.getText());
            setupprofile.setDouble(7, emercontact);

            setupprofile.setString(8, email.getText());

            setupprofile.setString(9, departmentname.getText());
            department_name = departmentname.getText();

            setupprofile.setString(10, employee_id);
            setupprofile.execute();
            System.out.println("Executed");
         }
         
    }
    
    public void cancel(ActionEvent event)
    {
        nationality.setText("");
        LocalDate cal=LocalDate.now();
        dateofbirth.setValue(cal);
        age.setText("");
        bloodgroup.setText(""); 
        contactno.setText("");
        emergencycontact.setText("");
        email.setText("");
        departmentname.setText("");
    }
    
}
