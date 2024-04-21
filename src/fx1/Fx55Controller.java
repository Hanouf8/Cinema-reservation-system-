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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author vip
 */
public class Fx55Controller implements Initializable {

    @FXML
    private ComboBox<String> food;
    @FXML
    private ComboBox<String> drinks;
    @FXML
    private TextField foodS;
    @FXML
    private TextField drinksS;
    @FXML
    private Button backto4;
    @FXML
    private Button nextto6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        food.getItems().addAll("Large popcorn -- 15$","Mediam popcorn-- 10$","Small popcorn-- 5$");
        drinks.getItems().addAll("pipse-- 5$","slash-- 7$","water-- 2$");
        
        food.setOnAction(this::getFood);
        drinks.setOnAction(this::getdrink);
        
        // TODO
    }    

    @FXML
    private void foodAction(ActionEvent event) {
    }

    @FXML
    private void drinksAction(ActionEvent event) {
    }

    @FXML
    private void foodSAction(ActionEvent event) {
    }

    @FXML
    private void drinksSAction(ActionEvent event) {
    }

    @FXML
    private void backto4Action(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fx4.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error 2");
        }
    }

    @FXML
    private void nextto6Action(ActionEvent event) {
        
        file();
        JOptionPane.showMessageDialog(null, "Your information is recored successfully (: ");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fx6.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error 2");
        }
    }
    
    public void getFood(ActionEvent event){
        String MyFood=food.getValue();
        foodS.setText(MyFood);  
    }
    public void getdrink(ActionEvent event){
        String MyDrink=drinks.getValue();
        drinksS.setText(MyDrink);  
    }
    public void file(){
        String strfood = food.getValue();
        String strdrinks = drinks.getValue();
        
        
        try{
        FileWriter fw = new FileWriter ("customer.txt",true);
        PrintWriter printfile = new PrintWriter (fw);
        printfile.print(" ******** CUSTOMER CHOICE OF FOOD : ********\n");
        printfile.print("Food: "+strfood+"\n");
        printfile.print("Drinks: "+strdrinks+"\n");
        printfile.print("---------------------------------------\n\n");
        printfile.close();
        }
        catch(IOException e){
        System.out.print(e.getMessage()); 
        }
    }
}
