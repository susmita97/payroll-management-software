/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

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
public class ManagerViewFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton viewyourrecords;

    @FXML
    private JFXButton modifyyourrecords;

    @FXML
    private JFXButton searchemployee;

    @FXML
    private JFXButton modifyemployee;
    
    @FXML
    private JFXButton logout;
    
    public static boolean viewyourrecordsb;
    public static boolean modifyyourrecordsb;
    public static boolean searchemployeeb;
    public static boolean modifyemployeeb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void commonfun3() throws IOException
    {
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("ManagerViewFXML2.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
        modifyyourrecords.getScene().getWindow().hide();
    }
    
    public void commonfunc3() throws IOException
    {
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("ManagerViewFXML3.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
        viewyourrecords.getScene().getWindow().hide();
    }
    
     public void logout(ActionEvent event) throws IOException
    {
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("/login/LoginFXML.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
        logout.getScene().getWindow().hide();
    }
     
    public void viewyourrecordsf(ActionEvent event) throws IOException
    {
        viewyourrecordsb=true;
        commonfunc3();
    }
    
    public void modifyyourrecordsf(ActionEvent event) throws IOException
    {
        modifyyourrecordsb=true;
        commonfun3();
    }
    
     public void searchemployeef(ActionEvent event) throws IOException
    {
        searchemployeeb=true;
        commonfunc3();
    }
     
    public void modifyemployeef(ActionEvent event) throws IOException
    {
        modifyemployeeb=true;
        commonfun3();
        
    }
}
