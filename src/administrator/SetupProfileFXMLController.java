/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class SetupProfileFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton personald;

    @FXML
    private JFXButton salaryd;

    @FXML
    private JFXButton jobd;

    @FXML
    private JFXButton leaved;

    @FXML
    private JFXButton goback;

    @FXML
    private Label recordavailable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void personald(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/personaldetails/PersonalDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.setTitle("Personal Details");
       stage5.show();  
    }
    
    public void jobd(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/jobdetails/JobDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show();  
    }
    
    public void salaryd(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/salarydetails/SalaryDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show();  
    }
    
    public void leaved(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("/leavedetails/LeaveDetailsFXML1.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show();  
    }
    
    public void goback(ActionEvent event) throws IOException
    {
       Stage stage5=new Stage();
       Parent root5 = FXMLLoader.load(getClass().getResource("AdminViewFXML.fxml"));
       Scene scene5=new Scene(root5);
       stage5.setScene(scene5);
       stage5.show(); 
       goback.getScene().getWindow().hide();
    }
}
