/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runsetup;
import mainfolder.RunSetupClass;
import com.jfoenix.controls.JFXButton;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
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
public class RunSetupController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton next;
    
    @FXML
    public Label createdb;

    @FXML
    public Label done;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    
    
    public void runnext(ActionEvent event) throws IOException
    {
       Stage stage4=new Stage();
       Parent root4 = FXMLLoader.load(getClass().getResource("AdminAccFXML.fxml"));
       Scene scene4=new Scene(root4);
       stage4.setScene(scene4);
       stage4.setTitle("Create an Administrator Account");
       stage4.setMaximized(true);
       stage4.show();
       next.getScene().getWindow().hide();
    }
    
     
     
         
     
    
}
