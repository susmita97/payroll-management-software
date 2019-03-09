/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainfolder;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class WelcomeFXML1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton getstarted;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getstarted(ActionEvent event) throws IOException
    {
       Stage stage1=new Stage();
       Parent root1 = FXMLLoader.load(getClass().getResource("WelcomeFXML.fxml"));
       Scene scene1=new Scene(root1);
       stage1.setScene(scene1);
       stage1.setTitle("Paysheet Solutions");
       stage1.setMaximized(true);
       stage1.show();  
       getstarted.getScene().getWindow().hide();
    }
}
