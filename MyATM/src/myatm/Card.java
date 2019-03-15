/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myatm;

/**
 *
 * @author CFast
 */
public class Card {
   private String cardNumber = "1234";
   private String checkNumber;
    public void setcardNumber(String cardNumber){
        checkNumber = cardNumber;
    }
   public boolean validation (){
       if (checkNumber.equals(cardNumber)){
           return true;
       }else{
        return false;
       }
   }
     static  double balance=0.0;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    
}
