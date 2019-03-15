/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myatm;

import javafx.application.Application;
import javafx.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 *
 * @author CFast
 */
public class MyATM extends Application {
    public static void main(String args [] ) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("ATM");
       
       HomeScreen homescreen = new HomeScreen(primaryStage);
       LoginScreen loginscreen = new LoginScreen(primaryStage);
       Withdraw withdraw = new Withdraw(primaryStage);
       Deposit deposit = new Deposit (primaryStage);
       
       loginscreen.prepareScene();
       homescreen.prepareScene();
       withdraw.prepareScene();
       deposit.prepareScene();
       
       homescreen.setLoginscreen(loginscreen);
       loginscreen.setHomescreen(homescreen);
       homescreen.setWithdraw(withdraw);
       homescreen.setDeposit(deposit);
       deposit.setHomescreen(homescreen);
       withdraw.setHomescreen(homescreen);
             
       primaryStage.setScene(loginscreen.getScene());
       primaryStage.show();
   
    }

        
}
//primaryStage.setTitle("My ATM Login Screen");
   //     primaryStage.show();