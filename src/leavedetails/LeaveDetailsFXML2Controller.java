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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class LeaveDetailsFXML2Controller implements Initializable {

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
            Logger.getLogger(LeaveDetailsFXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
