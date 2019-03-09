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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author susmita
 */
public class AdminViewFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private JFXButton viewyourrecords;

    @FXML
    private JFXButton modifyyourrecords;

    @FXML
    private JFXButton searchchairp;

    @FXML
    private JFXButton searchmanager;

    @FXML
    private JFXButton searchemployee;

    @FXML
    private JFXButton setupprofile;

    @FXML
    private JFXButton modifychairp;

    @FXML
    private JFXButton modifymanager;

    @FXML
    private JFXButton modifyemployee;
    
    @FXML
    private JFXButton logout;
    
    public static boolean insertnewrecords;
    public static boolean viewyourrecordsb;
    public static boolean modifyyourrecordsb;
    public static boolean searchchairpb;
    public static boolean searchmanagerb;
    public static boolean searchemployeeb;
    public static boolean setupprofileb;
    public static boolean modifychairpb;
    public static boolean modifymanagerb;
    public static boolean modifyemployeeb;
    public static boolean viewotheradministrators;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 
    
    public void commonfun() throws IOException
    {
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("AdminViewFXML2.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
        modifyyourrecords.getScene().getWindow().hide();
    }
    public void commonfunc() throws IOException
    {
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("AdminViewFXML3.fxml"));
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
        commonfunc();
    }
    
    public void modifyyourrecordsf(ActionEvent event) throws IOException
    {
        modifyyourrecordsb=true;
        commonfun();
    }
    
    public void searchchairpf(ActionEvent event) throws IOException
    {
        searchchairpb=true;
        commonfunc();
    }
    
    public void searchmanagerf(ActionEvent event) throws IOException
    {
        searchmanagerb=true;
        commonfunc();
    }
    
    public void searchemployeef(ActionEvent event) throws IOException
    {
        searchemployeeb=true;
        commonfunc();
    }
    
    public void modifychairpf(ActionEvent event) throws IOException
    {
        modifychairpb=true;
        commonfun();
    }
    
    public void modifymanagerf(ActionEvent event) throws IOException
    {
        modifymanagerb=true;
        commonfun();
    }
    
    public void modifyemployeef(ActionEvent event) throws IOException
    {
        modifyemployeeb=true;
        commonfun();
        
    }
    
    public void insertnew(ActionEvent event) throws IOException
    {
        insertnewrecords=true;
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("InsertFXML1.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();

    }
    
    public void viewotheradmin(ActionEvent event) throws IOException
    {
        viewotheradministrators=true;
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("ViewOtherAdministratorsFXML.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
    }
    
    public void setupyourprofile(ActionEvent event) throws IOException
    {
        setupprofileb=true;
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("SetupProfileFXML.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
    }
    
    public void deleterecords(ActionEvent event) throws IOException
    {
        Stage stage5=new Stage();
        Parent root5 = FXMLLoader.load(getClass().getResource("DeleteRecordsFXML.fxml"));
        Scene scene5=new Scene(root5);
        stage5.setScene(scene5);
        stage5.show();
    }
}
