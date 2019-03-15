package myatm;

import java.util.Iterator;
import java.util.LinkedList; 
import java.util.Deque; 
  
public class TransactionsDeque
{   
   public static Deque<Transaction> history = new LinkedList<Transaction>(); 
   public static Deque<Transaction> historyNext = new LinkedList<Transaction>(); 
  } 
