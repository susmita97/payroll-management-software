/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainfolder;
import runsetup.RunSetupController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class WelcomeFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton runsetup1;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton exit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void runsetup(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
    {
       Stage stage2=new Stage();
       Parent root2 = FXMLLoader.load(getClass().getResource("/runsetup/RunSetup.fxml"));
       Scene scene2=new Scene(root2);
       stage2.setScene(scene2);
       stage2.setTitle("Run Setup");
       stage2.setMaximized(true);
       stage2.show(); 
       runsetup1.getScene().getWindow().hide();
       
      // RunSetupClass.runSetupDBConnect();
       
    }
    
    public void loginpage(ActionEvent event) throws IOException
    {
       Stage stage3=new Stage();
       Parent root3 = FXMLLoader.load(getClass().getResource("/login/LoginFXML.fxml"));
       Scene scene3=new Scene(root3);
       stage3.setScene(scene3);
       stage3.setTitle("Login to your Account");
       stage3.setMaximized(true);
       stage3.show();
       login.getScene().getWindow().hide();
    }
    
    public void exitgui(ActionEvent event)
    {
        exit.getScene().getWindow().hide();
        
    }
            
    
}
