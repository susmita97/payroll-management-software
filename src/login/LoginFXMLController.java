/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class LoginFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label label;

    @FXML
    private JFXTextField usertxt;

    @FXML
    private JFXButton loginb;

    @FXML
    private Label loginlbl;

    @FXML
    private JFXPasswordField passtxt;

    @FXML
    private ImageView image;

    @FXML
    private JFXComboBox<String> combotype;
    
    public static String selectedvalue;
    public static String employeeid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         List<String> list=new ArrayList<>();
    
        ObservableList<String> oblist= FXCollections.observableList(list);
        oblist.add("Administrator");
        oblist.add("Chairperson");
        oblist.add("Manager");
        oblist.add("Employee");
        combotype.setItems(oblist);
    }    
    
    public void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
    {
       System.out.println(combotype.getValue());
        selectedvalue=combotype.getValue();
        Connection conlogin;
        conlogin=DBConnectLogin.dbConnect();
        System.out.println(usertxt.getText());
        System.out.println(passtxt.getText());
        String user=usertxt.getText();
        String pass=passtxt.getText();
        if(selectedvalue.equals("Administrator"))
        {
            PreparedStatement admin=conlogin.prepareCall("select *from ADMINCREDENTIALS");
            if(admin.execute())
            {
                ResultSet rs=admin.getResultSet();
                while(rs.next())
                {
                    for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
                   {
                        String username=rs.getString(i);
                        System.out.println(rs.getString(i));
                        String password=rs.getString(i+1);
                        System.out.println(rs.getString(i+1));
                    
                        if(user.equals(username) && pass.equals(password))
                        {
                            loginlbl.setText("Login successful");
                            loginsuccess();
                            break;
                    
                        }
                
                         i=i+1;
                
                    }
                    
                }
            }
            
        }
        else if(selectedvalue.equals("Chairperson"))
        {
            PreparedStatement chairp=conlogin.prepareCall("select *from CHAIRPERSONCREDENTIALS");
            
            if(chairp.execute())
            {
                ResultSet rs=chairp.getResultSet();
                while(rs.next())
                {
                    for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
                   {
                        String username=rs.getString(i);
                        System.out.println(rs.getString(i));
                        String password=rs.getString(i+1);
                        System.out.println(rs.getString(i+1));
                    
                        if(user.equals(username) && pass.equals(password))
                        {
                            loginlbl.setText("Login successful");
                            loginsuccess();
                            break;
                    
                        }
                
                         i=i+1;
                
                    }
                    
                }
            }
        }
        else if(selectedvalue.equals("Manager"))
        {
            PreparedStatement manager=conlogin.prepareCall("select *from MANAGERCREDENTIALS");
            if(manager.execute())
            {
                ResultSet rs=manager.getResultSet();
                while(rs.next())
                {
                    for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
                   {
                        String username=rs.getString(i);
                        System.out.println(rs.getString(i));
                        String password=rs.getString(i+1);
                        System.out.println(rs.getString(i+1));
                    
                        if(user.equals(username) && pass.equals(password))
                        {
                            loginlbl.setText("Login successful");
                            loginsuccess();
                            break;
                    
                        }
                
                         i=i+1;
                
                    }
                    
                }
            }
        }
        else
        {
            PreparedStatement employee=conlogin.prepareCall("select *from EMPLOYEECREDENTIALS");
            
             if(employee.execute())
            {
                ResultSet rs=employee.getResultSet();
                while(rs.next())
                {
                    for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
                   {
                        String username=rs.getString(i);
                        System.out.println(rs.getString(i));
                        String password=rs.getString(i+1);
                        System.out.println(rs.getString(i+1));
                    
                        if(user.equals(username) && pass.equals(password))
                        {
                            loginlbl.setText("Login successful");
                            loginsuccess();
                            break;
                    
                        }
                
                         i=i+1;
                
                    }
                    
                }
            }
        }
        conlogin.close();
    }
    
    public void loginsuccess() throws IOException
    {
        if(loginlbl.getText().equals("Login successful"))
        {
            if(combotype.getValue().equals("Administrator"))
            {
                Stage stage5=new Stage();
                Parent root5 = FXMLLoader.load(getClass().getResource("/administrator/AdminViewFXML.fxml"));
                Scene scene5=new Scene(root5);
                stage5.setScene(scene5);
                stage5.setMaximized(true);
                stage5.show();
                loginb.getScene().getWindow().hide();
                
            }
            else if(combotype.getValue().equals("Chairperson"))
            {
                Stage stage5=new Stage();
                Parent root5 = FXMLLoader.load(getClass().getResource("/chairperson/ChairpersonViewFXML.fxml"));
                Scene scene5=new Scene(root5);
                stage5.setScene(scene5);
                stage5.setMaximized(true);
                stage5.show();
                loginb.getScene().getWindow().hide(); 
            }
            else if(combotype.getValue().equals("Manager"))
            {
                Stage stage5=new Stage();
                Parent root5 = FXMLLoader.load(getClass().getResource("/manager/ManagerViewFXML.fxml"));
                Scene scene5=new Scene(root5);
                stage5.setScene(scene5);
                stage5.setMaximized(true);
                stage5.show();
                loginb.getScene().getWindow().hide();
                
            }
            else
            {
                Stage stage5=new Stage();
                Parent root5 = FXMLLoader.load(getClass().getResource("/employee/EmployeeViewFXML.fxml"));
                Scene scene5=new Scene(root5);
                stage5.setScene(scene5);
                stage5.setMaximized(true);
                stage5.show();
                loginb.getScene().getWindow().hide();
                
            }
        }
    }
}
    
    
        
