/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leavedetails;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class LeaveDetailsFXML1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField days;

    @FXML
    private JFXDatePicker date1;

    @FXML
    private JFXDatePicker date2;

    @FXML
    private JFXTextField leavepermitted;

    @FXML
    private JFXTextField leaveremaining;

    @FXML
    private JFXTextField leavelimitexceeded;

    @FXML
    private JFXComboBox<String> leavetype;

    @FXML
    private JFXTextField amount;
    
     @FXML
    private JFXRadioButton yesd;

    @FXML
    private JFXRadioButton nod;
    
    ToggleGroup group=new ToggleGroup();
    
    public static Connection conn;
    public static String employee_id;
    public static double leaveamount;
    public static String deduction;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> list=new ArrayList<>();
    
        ObservableList<String> oblist= FXCollections.observableList(list);
        oblist.add("Conventional");
        oblist.add("Vacation");
        oblist.add("Sick");
        oblist.add("Casual");
        leavetype.setItems(oblist);
        
        yesd.setToggleGroup(group);
        nod.setToggleGroup(group);
        
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
                    Logger.getLogger(LeaveDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LeaveDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            else if(administrator.AdminViewFXMLController.setupprofileb)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ADMINISTRATOR","root","susmita12");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LeaveDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LeaveDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LeaveDetailsFXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
        
    }
    
    public void getrecords() throws SQLException
    {
        PreparedStatement search=conn.prepareCall("select *from LEAVEDETAILS where employee_id=?");
            search.setString(1,employee_id);
            if(search.execute())
            {
                ResultSet rs=search.getResultSet();
                int i=1;
                rs.next();
                while(i<rs.getMetaData().getColumnCount())
                {
                    i++;
                    leavetype.setValue(rs.getString(i));
                    i++;
                    days.setText(rs.getString(i));
                    i++;
                    Date cal=rs.getDate(i);
                    LocalDate dateis1=cal.toLocalDate();
                    date1.setValue(dateis1);
                    i++;
                    Date cal2=rs.getDate(i);
                    LocalDate dateis2=cal2.toLocalDate();
                    date2.setValue(dateis2);
                    i++;
                    leavepermitted.setText(rs.getString(i));
                    i++;
                    leaveremaining.setText(rs.getString(i));
                    i++;
                    leavelimitexceeded.setText(rs.getString(i));
                    i++;
                    deduction=rs.getString(i);
                    if(deduction.equals("yes"))
                    {
                        yesd.setSelected(true);
                    }
                    if(deduction.equals("no"))
                    {
                        nod.setSelected(true);
                    }
                    i++;
                    amount.setText(rs.getString(i));
                    i++;
                    break;
                    
                }
                
            }
 
    }
    
     public void save(ActionEvent event) throws SQLException
    {
        employee_id=personaldetails.PersonalDetailsFXML1Controller.employee_id;
        if(yesd.isSelected())
        {
           deduction="yes"; 
        }
        if(nod.isSelected())
        {
           deduction="no"; 
        }
        if (administrator.AdminViewFXMLController.insertnewrecords) 
        {
            PreparedStatement insertrecords = conn.prepareCall("insert into LEAVEDETAILS values((select employee_id from PERSONALDETAILS where employee_id=? ),?,?,?,?,?,?,?,?,?)");

            insertrecords.setString(1, employee_id);

            String leavetype2 = leavetype.getValue();
            insertrecords.setString(2, leavetype2);

            int daysno = Integer.parseInt(days.getText());
            insertrecords.setInt(3, daysno);

            LocalDate cal = date1.getValue();
            Date date1is = Date.valueOf(cal);
            insertrecords.setDate(4, date1is);

            LocalDate cal2 = date2.getValue();
            Date date2is = Date.valueOf(cal2);
            insertrecords.setDate(5, date2is);

            insertrecords.setString(6, leavepermitted.getText());

            insertrecords.setString(7, leaveremaining.getText());

            insertrecords.setString(8, leavelimitexceeded.getText());

            insertrecords.setString(9, deduction);

            double amountis = Double.parseDouble(amount.getText());
            insertrecords.setDouble(10, amountis);
            leaveamount = amountis;

            insertrecords.execute();
            System.out.println("Executed");
        }
        else if (administrator.AdminViewFXMLController.setupprofileb)
        {
            PreparedStatement setupprofile = conn.prepareCall("insert into LEAVEDETAILS values((select employee_id from PERSONALDETAILS where employee_id=? ),?,?,?,?,?,?,?,?,?)");

            setupprofile.setString(1, employee_id);

            String leavetype2 = leavetype.getValue();
            setupprofile.setString(2, leavetype2);

            int daysno = Integer.parseInt(days.getText());
            setupprofile.setInt(3, daysno);

            LocalDate cal = date1.getValue();
            Date date1is = Date.valueOf(cal);
            setupprofile.setDate(4, date1is);

            LocalDate cal2 = date2.getValue();
            Date date2is = Date.valueOf(cal2);
            setupprofile.setDate(5, date2is);

            setupprofile.setString(6, leavepermitted.getText());

            setupprofile.setString(7, leaveremaining.getText());

            setupprofile.setString(8, leavelimitexceeded.getText());

            setupprofile.setString(9, deduction);

            double amountis = Double.parseDouble(amount.getText());
            setupprofile.setDouble(10, amountis);
            leaveamount = amountis;

            setupprofile.execute();
            System.out.println("Executed");
        }
        else
        {
            PreparedStatement modifyrecords=conn.prepareCall("update LEAVEDETAILS set leavetype=?,days=?,date1=?,date2=?,leave_permitted_for=?,leave_remaining_for=?,leave_limit_exceeded_for=?,deduction=?,amount=? where employee_id=?");
            

            String leavetype2 = leavetype.getValue();
            modifyrecords.setString(1, leavetype2);

            int daysno = Integer.parseInt(days.getText());
            modifyrecords.setInt(2, daysno);

            LocalDate cal = date1.getValue();
            Date date1is = Date.valueOf(cal);
            modifyrecords.setDate(3, date1is);

            LocalDate cal2 = date2.getValue();
            Date date2is = Date.valueOf(cal2);
            modifyrecords.setDate(4, date2is);

            modifyrecords.setString(5, leavepermitted.getText());

            modifyrecords.setString(6, leaveremaining.getText());

            modifyrecords.setString(7, leavelimitexceeded.getText());

            modifyrecords.setString(8, deduction);

            double amountis = Double.parseDouble(amount.getText());
            modifyrecords.setDouble(9, amountis);
            leaveamount = amountis;
            
            modifyrecords.setString(10, employee_id);
            modifyrecords.execute();
            System.out.println("Executed");
        }
        
    }
    
}
