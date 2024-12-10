/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fx1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vip
 */
public class Fx4Controller implements Initializable {

    @FXML
    private Button nextto5;
    @FXML
    private Button backto3;
    @FXML
    private ChoiceBox<String> film;
    @FXML
    private ChoiceBox<String> time;
    @FXML
    private ChoiceBox<String> screen;
    @FXML
    private ChoiceBox<String> quntity;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        film.getItems().addAll("Bird Man","Bat Man","R.Dogs","Truman Show","La mains","Vertigo");
        screen.getItems().addAll("Haifa Mall screen","Aziz Mall screen","redsea Mall screeen");
        quntity.getItems().addAll("1","2","3","4","5","6","7","8","9");
        time.getItems().addAll("20:00","15:00","12:00","9:00","5:00","3:00","2:00","1:00");
        // TODO
        
        
    }    

    @FXML
    private void nextto5Action(ActionEvent event) {
        
        file();
        JOptionPane.showMessageDialog(null, "Your information is recored successfully (: ");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fx55.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error 2");
        }
    }
        

    @FXML
    private void backto3Action(ActionEvent event) {
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
    private void filmAction(MouseEvent event) {
    }

    @FXML
    private void timeAction(MouseEvent event) {
    }

    @FXML
    private void sreenAction(MouseEvent event) {
    }

    @FXML
    private void quntityAction(MouseEvent event) {
    }

    @FXML
    private void dateAction(ActionEvent event) {
        
    }
    public void file(){
        String strfilm = film.getValue();
        String strtime = time.getValue();
        String strscreen = screen.getValue();
        String strquntity = quntity.getValue();
        
        try{
        FileWriter fw = new FileWriter ("customer.txt",true);
        PrintWriter printfile = new PrintWriter (fw);
        printfile.print(" ******** CUSTOMER CHOIC: ********\n");
        printfile.print("Film: "+strfilm+"\n");
        printfile.print("Time: "+strtime+"\n");
        printfile.print("Screen: "+strscreen+"\n");
        printfile.print("Quntity: "+strquntity+"\n");
        printfile.print("---------------------------------------\n\n");
        printfile.close();
        }
        catch(IOException e){
        System.out.print(e.getMessage()); 
        }
    }
    
}
