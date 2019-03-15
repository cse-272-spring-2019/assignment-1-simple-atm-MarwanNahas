/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myatm;

import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomeScreen {

    private LoginScreen loginscreen;
    private Scene scene;
    private Stage stage;
    private Withdraw withdraw;
    private Deposit deposit;
    private Card user = new Card();
    private boolean afternextpress, afterprevpress;
    Deque<Transaction> history = TransactionsDeque.history;
    Deque<Transaction> historyNext = TransactionsDeque.historyNext;

    //Iterator<Transaction> itr = TransactionsDeque.itr; 
    public HomeScreen(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {
        Label welcome = new Label(" Welcome To ATM");
        Button withdrawbutton = new Button("Withdraw");
        Button depositbutton = new Button("Deposit");
        Button balanceInquiry = new Button("Balance Inquiry");
        Button next = new Button("Next");
        Button previous = new Button("Previous");
        GridPane grid = new GridPane();
        grid.add(welcome, 1, 0);
        grid.add(withdrawbutton, 0, 1);
        grid.add(depositbutton, 2, 1);
        grid.add(balanceInquiry, 1, 2);
        grid.add(previous, 0, 3);
        grid.add(next, 2, 3);
        welcome.setFont(new Font("Verdana", 16));
        withdrawbutton.setFont(new Font("Verdana", 20));
        depositbutton.setFont(new Font("Verdana", 20));
        balanceInquiry.setFont(new Font("Verdana", 20));
        next.setFont(new Font("Verdana", 20));
        previous.setFont(new Font("Verdana", 20));
        grid.setStyle("-fx-base: lightblue");
        withdrawbutton.setStyle("-fx-base: lightgreen");
        depositbutton.setStyle("-fx-base: lightgreen");
        balanceInquiry.setStyle("-fx-base: lightgreen");
        next.setStyle("-fx-base: lightgreen");
        previous.setStyle("-fx-base: lightgreen");
        scene = new Scene(grid, 500, 300);
//        itr = history.iterator();
        withdrawbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(withdraw.getScene());
            }
        });
        depositbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(deposit.getScene());
            }
        });
        balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                welcome.setText(" My Balance :" + user.getBalance()+" LE");
                Transaction balanceinquiryTransaction = new Transaction(String.valueOf(user.getBalance()), "My Balance :");
                while (historyNext.size() > 0) {
                    Transaction thistrans = new Transaction("-", "-");
                    thistrans = historyNext.peek();
                    history.add(thistrans);
                    historyNext.pop();
                }
                if (history.size() == 5) {
                    history.pollFirst();
                }
                history.add(balanceinquiryTransaction);
            }
        });

        previous.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                Transaction thistrans = new Transaction("-", "-");
                if (history.size() > 0) {

                    if (afternextpress) {
                        thistrans = history.peekLast();

                        historyNext.add(thistrans);

                        history.pollLast();

                    }
                    if (history.size() > 0) {
                        thistrans = history.peekLast();
                        welcome.setText("   " + thistrans.type + "   " + thistrans.value);

                        historyNext.add(thistrans);

                        history.pollLast();
                        afternextpress = false;
                        afterprevpress = true;
                    }
                }
            }
        });
        next.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                Transaction thistrans = new Transaction("-", "-");
                if (historyNext.size() > 0) {

                    if (afterprevpress) {
                        thistrans = historyNext.peekLast();
                        history.add(thistrans);
                        historyNext.pollLast();

                    }
                    if (historyNext.size() > 0) {
                        thistrans = historyNext.peekLast();
                        welcome.setText("    " + thistrans.type + "    " + thistrans.value);
                        history.add(thistrans);
                        historyNext.pollLast();
                        afternextpress = true;
                        afterprevpress = false;
                    }
                }
            }
        });
    }

    public void setLoginscreen(LoginScreen loginscreen) {
        this.loginscreen = loginscreen;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
    }

    public Scene getScene() {
        return scene;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

}
