/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fx1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author vip
 */
public class Fx6Controller implements Initializable {

    @FXML
    private Button close;
    @FXML
    private TextField order;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         File file = new File("customer.txt");
     Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fx6Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     while (scanner.hasNext()) {
        final String lineFromFile = "\n"+scanner.nextLine()+"\n";
        order.appendText("\n"+lineFromFile+"\n");
            }
        // TODO
    }    

    @FXML
    private void closeAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void orderAction(ActionEvent event) throws FileNotFoundException {
        
       
    }
    
}
