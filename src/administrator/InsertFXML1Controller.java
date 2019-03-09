/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrator;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class InsertFXML1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox<String> combotype;

    @FXML
    private JFXTextField usertxt;

    @FXML
    private JFXPasswordField passtxt;
    
    @FXML
    private JFXPasswordField conpasstxt;

    @FXML
    private JFXButton next;
    
    @FXML
    private JFXTextField employeeidtxt;
    
    public static Connection conn;
    public static String selectedvalue;
    
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
    
    public void entercredentials(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
    {
        Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINCREDENTIALS","root","susmita12");
	System.out.println("Connection Established");
        selectedvalue=combotype.getValue();
        System.out.println(selectedvalue);
        System.out.println(usertxt.getText());
        System.out.println(passtxt.getText());
        if(selectedvalue.equals("Administrator")  && passtxt.getText().equals(conpasstxt.getText()))
        {
            PreparedStatement insertc=conn.prepareCall("insert into ADMINCREDENTIALS values(?,?,?)");
            insertc.setString(1,usertxt.getText());
            insertc.setString(2,passtxt.getText());
            insertc.setString(3,employeeidtxt.getText());
            insertc.execute();
            
               Stage stage5=new Stage();
               Parent root5 = FXMLLoader.load(getClass().getResource("InsertFXML2.fxml"));
               Scene scene5=new Scene(root5);
               stage5.setScene(scene5);
               stage5.show(); 
               next.getScene().getWindow().hide();
            
        }
        if(selectedvalue.equals("Chairperson") && passtxt.getText().equals(conpasstxt.getText()))
        {
            PreparedStatement insertc=conn.prepareCall("insert into CHAIRPERSONCREDENTIALS values(?,?,?)");
            insertc.setString(1,usertxt.getText());
            insertc.setString(2,passtxt.getText());
            insertc.setString(3,employeeidtxt.getText());
            insertc.execute();
            
              
               Stage stage5=new Stage();
               Parent root5 = FXMLLoader.load(getClass().getResource("InsertFXML2.fxml"));
               Scene scene5=new Scene(root5);
               stage5.setScene(scene5);
               stage5.show();next.getScene().getWindow().hide(); 
            
        }
        if(selectedvalue.equals("Manager") && passtxt.getText().equals(conpasstxt.getText()))
        {
            PreparedStatement insertc=conn.prepareCall("insert into MANAGERCREDENTIALS values(?,?,?)");
            insertc.setString(1,usertxt.getText());
            insertc.setString(2,passtxt.getText());
            insertc.setString(3,employeeidtxt.getText());
            insertc.execute();
            
               Stage stage5=new Stage();
               Parent root5 = FXMLLoader.load(getClass().getResource("InsertFXML2.fxml"));
               Scene scene5=new Scene(root5);
               stage5.setScene(scene5);
               stage5.show(); 
               next.getScene().getWindow().hide();
            
        }
        if(selectedvalue.equals("Employee") && passtxt.getText().equals(conpasstxt.getText()))
        {
            PreparedStatement insertc=conn.prepareCall("insert into EMPLOYEECREDENTIALS values(?,?,?)");
            insertc.setString(1,usertxt.getText());
            insertc.setString(2,passtxt.getText());
            insertc.setString(3,employeeidtxt.getText());
            insertc.execute();
            
               Stage stage5=new Stage();
               Parent root5 = FXMLLoader.load(getClass().getResource("InsertFXML2.fxml"));
               Scene scene5=new Scene(root5);
               stage5.setScene(scene5);
               stage5.show(); 
               next.getScene().getWindow().hide();
            
        }
    }
    
}
