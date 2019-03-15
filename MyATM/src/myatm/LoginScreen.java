/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myatm;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.awt.Color;

    public class LoginScreen  {
  private  HomeScreen homescreen;
   private Card validate = new Card();
    
   private Scene scene;
   private Stage stage;

    public LoginScreen(Stage stage) {
        this.stage = stage;
    }

    
    
    public void prepareScene(){
        
        Label cardNumberlabel = new Label ("Card Number: ");
        Label wrongnumber = new Label ();
        TextField cardNumberfield = new TextField ();
        Button enter = new Button ("Enter");
        cardNumberlabel.setFont(new Font("Verdana", 20));
        enter.setFont(new Font("Verdana", 15));
        wrongnumber.setFont(new Font("Verdana", 14));
        cardNumberlabel.setStyle("-fx-base: lightgreen");
        enter.setStyle("-fx-base: lightgreen");
        
        GridPane grid = new GridPane();
        grid.add(cardNumberlabel, 0, 5);
        grid.add(cardNumberfield, 1,5 );
        grid.add(enter,1,7);
        grid.add(wrongnumber, 1, 6);
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               validate.setcardNumber(cardNumberfield.getText());
               if (validate.validation()){
                stage.setScene(homescreen.getScene());
               }
               else{
                   wrongnumber.setText("Please Enter The Right Card Number");
               }
               
            }
        });
         grid.setStyle("-fx-base: lightblue");
       scene = new Scene (grid,500,300);  
      
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setHomescreen(HomeScreen homescreen) {
        this.homescreen = homescreen;
    }
    
    }
  