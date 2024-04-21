/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fx1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vip
 */
public class Fx21Controller implements Initializable {

    @FXML
    private Button back;
    @FXML
    private Button next;
    @FXML
    private TextField name;
    @FXML
    private TextField pass;
    @FXML
    private TextField age;
    @FXML
    private TextField phone;
    @FXML
    private TextField Email;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton female;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backAction(ActionEvent event) {
        
        // move the previouse page 
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fx2.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error 2");
        }
    }

    @FXML
    private void nextAction(ActionEvent event) throws Exception { 
        
     //Check input validation 
      InputInvalid();
      

      // call file method to write 
       file();
       JOptionPane.showMessageDialog(null, "Your information is recored successfully (: ");
         
       
       // move to the next page 
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fx3s.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error 2");
            
        }
        
   
         
    }

    @FXML
    private void nameAction(ActionEvent event) {
    }

    @FXML
    private void passAction(ActionEvent event) {
    }

    @FXML
    private void ageAction(ActionEvent event) {
    }

    @FXML
    private void phoneAction(ActionEvent event) {
    }

    @FXML
    private void EmailAction(ActionEvent event) {
    }

    @FXML
    private void maleAction(ActionEvent event) {
    }

    @FXML
    private void femaleAction(ActionEvent event) {
    }
    
    
     // save user information in a file 
    
      public void file() {
          
          String gen;
      if(male.isSelected())
          gen="Male";
      else
          gen="Female";
      String strName = name.getText();
      String strpass = pass.getText();
      String strphone = phone.getText();
      String strEmail = Email.getText();
    
      
      
        try{
        FileWriter fw = new FileWriter ("customer.txt",true);
        PrintWriter printfile = new PrintWriter (fw);
         printfile.print(" ******** CUSTOMER INFORMATION : ********\n");
        printfile.print("Name: "+strName+"\n");
        printfile.print("Passowrd: "+strpass+"\n");
        printfile.print("Phone number: "+strphone+"\n");
        printfile.print("Email: "+strEmail+"\n");
        printfile.print("Gender: "+gen+"\n");
        printfile.print("---------------------------------------\n\n");
        printfile.close();
        }
        catch(IOException e){
        System.out.print(e.getMessage()); 
        }
}
      
      
      
      
      
      
     // method that check the Validation of user input
      
    private void InputInvalid() throws Exception { 
        
        if(name.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Please Enter your Name! ");
            throw new Exception();
        }
        
        NameInvalid();

        
        
         if(pass.getText().length()==0)
       {
        JOptionPane.showMessageDialog(null, "Please Enter your Password! ");
        throw new Exception();
       }
         passInvalid();
         
         
         
         if(age.getText().length()==0)
       {
        JOptionPane.showMessageDialog(null, "Please Enter your Age ! ");
        throw new Exception();
       }
         ageInvalid();
         
         
         
         if(phone.getText().length()==0)
       {
        JOptionPane.showMessageDialog(null, "Please Enter your Phone number! ");
        throw new Exception();
       }
         mobileInvalid();
         
         
         if(Email.getText().length()==0)
       {
        JOptionPane.showMessageDialog(null, "Please Enter your Email! ");
        throw new Exception();
       }
         emailInvalid();
        
    }
    
    
    
    
    
    //Check if name contains number
    
    private void NameInvalid() throws Exception { 
        if(!nameNumber())
       {
        name.setStyle("-fx-border-coloer:red;-fxborder-width:2px;");
        JOptionPane.showMessageDialog(null, "Only Letters Allowed! ");
        throw new Exception();
       }
    } 
     
    // Check if name contains number 
    
    private boolean nameNumber() 
    { 
        return name.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");  
     }
    
    
    
    
    //Check if password is 8 digit only
    
    private void passInvalid() throws Exception { 
        if(!pass())
       {
        JOptionPane.showMessageDialog(null, "Please Enter 8 digit only  ");
        throw new Exception();
       }
    } 
     
    // Check if password is 8 digit only
    
    private boolean pass() throws Exception 
    { 
        return pass.getText().matches("\\d{8}");  
    }
    
    
    //Check if phone number  is 10 digit only
    
    private void mobileInvalid() throws Exception { 
        if(!mobile())
       {
        JOptionPane.showMessageDialog(null, "Please Begin with (05) and then enter 8 number only !");
        throw new Exception();
       }
    } 
     
    //Check if phone number  is 10 digit only
    
    private boolean mobile() throws Exception 
    { 
        return phone.getText().matches("(05)[0-9]{8}");  
    }
    
    
    
     // check if email is correct 
    
     private void emailInvalid() throws Exception { 
        if(!email())
       {
        JOptionPane.showMessageDialog(null, "Please Enter Email correctly!");
        throw new Exception();
       }
    } 
     
    //check if phone number  is 10 digit only
     
    private boolean email() throws Exception 
    { 
        return Email.getText().matches("^(.+)@(.+)$");  
    }
    
    //check user age is more than 17
    
    private void ageInvalid() throws Exception { 
        if(age())
       {
        JOptionPane.showMessageDialog(null, "You are less than 18!");
        throw new Exception();
       }
    } 
     
    ////check user age is more than 17
    private boolean age() throws Exception 
    { 
        return age.getText().matches("[0-9][10-17]");  
    }
    
    
}
