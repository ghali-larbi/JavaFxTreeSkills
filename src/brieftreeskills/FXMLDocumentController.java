/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brieftreeskills;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Pane paneInscription;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField userN;
    @FXML
    private TextField pass;
    @FXML
    private RadioButton apprenant;
    @FXML
    private RadioButton staff;
    @FXML
    private Button btnInscription;
    @FXML
    private TextField cin;
    @FXML
    private TextField logUserName;
    @FXML
    private TextField logPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private ToggleGroup role;
   
     Connection connection; 
     Statement statement;
    @FXML
    private Pane paneLogin;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paneLogin.setVisible(false);
        paneInscription.setVisible(false);
        
    }    

    @FXML
    private void inscription(ActionEvent event) {  
        String sql="";
        try
    { 
        connection con=new connection();
      Connection cnx=con.getConnection();
       if(apprenant.isSelected()){
    sql="insert into user values('"+cin.getText()+"','"+nom.getText()+"','"+prenom.getText()+"','"+userN.getText()+"','"+pass.getText()+"','"+apprenant.getText()+"')";
       }
       if(staff.isSelected()){
       sql="insert into user values('"+cin.getText()+"','"+nom.getText()+"','"+prenom.getText()+"','"+userN.getText()+"','"+pass.getText()+"','"+staff.getText()+"')";
       }
        statement=cnx.createStatement();
        statement.executeQuery(sql);
        JOptionPane.showMessageDialog(null, "incription done!!", "InfoBox: ",JOptionPane.INFORMATION_MESSAGE);
        paneInscription.setVisible(false);
        
    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    }
    @FXML
    private void login(ActionEvent event) {
          try
    { 
        connection con=new connection();
      Connection cnx=con.getConnection();
    String  sql="select * from user where userName='"+logUserName.getText()+"' and password='"+logPassword.getText()+"'";
     statement=cnx.createStatement();
        ResultSet res= statement.executeQuery(sql);
        if(res.next()){
       JOptionPane.showMessageDialog(null, "authentification done!!", "InfoBox: ",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
       JOptionPane.showMessageDialog(null, "invalide!!", "error: ",JOptionPane.INFORMATION_MESSAGE);

        }
    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }   
    }

    @FXML
    private void pageInscription(ActionEvent event) {
        paneInscription.setVisible(true);
        paneLogin.setVisible(false);
    }
    @FXML
    private void pageLogin(ActionEvent event) {
        paneLogin.setVisible(true);
        paneLogin.setLayoutY(10);
        paneInscription.setVisible(false);
    }
}
