/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class InsertFXML2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    
}
