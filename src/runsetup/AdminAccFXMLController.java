/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runsetup;

import com.jfoenix.controls.JFXButton;
import login.LoginFXMLController;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class AdminAccFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private JFXTextField usertxt;

    @FXML
    private JFXButton nextb;

    @FXML
    private JFXPasswordField passtxt;

    @FXML
    private JFXPasswordField conpasstxt;
    
    @FXML
    private Label acccreated;
    
    @FXML
    private JFXTextField employeeidtxt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void loginnext(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
    {
       String username=usertxt.getText();
       String password=passtxt.getText();
       String confirmpassword=conpasstxt.getText();
       if(password.equals(confirmpassword))
       {
          Connection con1;
          con1=DBConnect.dbConnect();
          PreparedStatement admincreate=con1.prepareCall("insert into ADMINCREDENTIALS values(?,?,?)");
          admincreate.setString(1,username);
          admincreate.setString(2,password);
          admincreate.setString(3,employeeidtxt.getText());
          admincreate.execute();
          acccreated.setText("Account Created");
          
          Stage stage5=new Stage();
          Parent root5 = FXMLLoader.load(getClass().getResource("/login/LoginFXML.fxml"));
          Scene scene5=new Scene(root5);
          stage5.setScene(scene5);
          stage5.setTitle("Login to your Account");
          stage5.setMaximized(true);
          stage5.show();
          nextb.getScene().getWindow().hide(); 
       }
       else
       {
           acccreated.setText("Password not entered correctly");
       }
       
       
        
    }
    
}
