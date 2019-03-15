/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myatm;

import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author CFast
 */
public class Withdraw {

    private Card user = new Card();
    private Stage stage;
    private Scene scene;
    private HomeScreen homescreen;
    Deque<Transaction> history = TransactionsDeque.history;
    Deque<Transaction> historyNext = TransactionsDeque.historyNext;

    public Withdraw(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {
        Label show = new Label();
        Label amount = new Label();
        Button b0 = new Button("0");
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button enter = new Button("Enter");
        Button GoToMainMenue = new Button("Go To Main Menu");
        Button reset = new Button("Reset");
        GridPane grid = new GridPane();
        grid.add(show, 6, 0);
        grid.add(b1, 1, 2);
        grid.add(b2, 2, 2);
        grid.add(b3, 3, 2);
        grid.add(b4, 1, 3);
        grid.add(b5, 2, 3);
        grid.add(b6, 3, 3);
        grid.add(b7, 1, 4);
        grid.add(b8, 2, 4);
        grid.add(b9, 3, 4);
        grid.add(b0, 2, 5);
        grid.add(enter, 0, 6);
        grid.add(amount, 6, 3);
        grid.add(GoToMainMenue, 6, 6);
        grid.add(reset, 6, 7);
         b0.setFont(new Font("Verdana", 15));
        b1.setFont(new Font("Verdana", 15));
        b2.setFont(new Font("Verdana", 15));
        b3.setFont(new Font("Verdana", 15));
        b4.setFont(new Font("Verdana", 15));
        b5.setFont(new Font("Verdana", 15));
        b6.setFont(new Font("Verdana", 15));
        b7.setFont(new Font("Verdana", 15));
        b8.setFont(new Font("Verdana", 15));
        b9.setFont(new Font("Verdana", 15));
        show.setFont(new Font("Verdana", 15));
        amount.setFont(new Font("Verdana", 15));
        GoToMainMenue.setFont(new Font("Verdana", 15));
        reset.setFont(new Font("Verdana", 15));
        enter.setFont(new Font("Verdana", 15));
        b0.setStyle("-fx-base: lightgreen");
        b1.setStyle("-fx-base: lightgreen");
        b2.setStyle("-fx-base: lightgreen");
        b3.setStyle("-fx-base: lightgreen");
        b4.setStyle("-fx-base: lightgreen");
        b5.setStyle("-fx-base: lightgreen");
        b6.setStyle("-fx-base: lightgreen");
        b7.setStyle("-fx-base: lightgreen");
        b8.setStyle("-fx-base: lightgreen");
        b9.setStyle("-fx-base: lightgreen");
        enter.setStyle("-fx-base: lightgreen");
        show.setStyle("-fx-base: lightgreen");
        GoToMainMenue.setStyle("-fx-base: lightgreen");
        reset.setStyle("-fx-base: lightgreen");
        b0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "0");
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "1");
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "2");
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "3");
            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "4");
            }
        });
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "5");
            }
        });
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "6");
            }
        });
        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "7");
            }
        });
        b8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "8");
            }
        });
        b9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText(show.getText() + "9");
            }
        });
        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (show.getText()==""){
                    show.setText("");
                }
                else {
                double withdrawmoney = Double.parseDouble(show.getText());
                double MyBalance = user.getBalance();
                if (MyBalance < withdrawmoney) {
                    amount.setText("There is not enough Balance");
                } else {
                    MyBalance -= withdrawmoney;
                    user.setBalance(MyBalance);
                    Transaction WithdrawTransaction = new Transaction(String.valueOf(withdrawmoney), "Withdraw");
                    while (historyNext.size() > 0) {
                        Transaction thistrans = new Transaction("-", "-");
                        thistrans = historyNext.peek();
                        history.add(thistrans);
                        historyNext.pop();
                    }
                    if (history.size() == 5) {
                        history.pollFirst();
                    }
                    history.add(WithdrawTransaction);
                    amount.setText("You have withdrawn " + withdrawmoney);
                    show.setText("");
                }
            }
            }});
        GoToMainMenue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(homescreen.getScene());
            }
        });
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show.setText("");
            }
        });
        grid.setStyle("-fx-base: lightblue");
        scene = new Scene(grid, 500, 300);

    }

    public Scene getScene() {
        return scene;
    }

    public void setHomescreen(HomeScreen homescreen) {
        this.homescreen = homescreen;
    }

}
