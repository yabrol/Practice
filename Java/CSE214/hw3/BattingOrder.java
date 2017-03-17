//imports
import java.lang.*;
import java.io.*;
import java.util.*;

/*******************************************
  * BattingOrder Class
  * queue that stores Batter objects
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 3 
  * @ Date:
  *      7/31/12
  **********************************************/

  public class BattingOrder extends LinkedList<Batter>
{
  //variable
  //private LinkedList<Batter> players;
  
  /********************
    * constructor makes an instance of BattingOrder
    * defines an empty queue
    ****************/
  public BattingOrder()
  {
    super();
  }
  
  /********************
    * isEmpty - returns true if head is null
    * precondition: battingorder must be instantiated
    * return: true if empty queue
    ****************/
  public boolean isEmpty()
  {
    return isEmpty();
  }
  
  /********************
    * enqueue - adds a batter to end of queue
    * paramerter: b = new batter
    * precondition: battingorder must be instantiated
    * postcondition: battter is added to end of queue
    ****************/
  public void enqueue(Batter b)
  {
    add(b);
    //players.addLast(b);
  }
  
  /********************
    * dequeue - removes first batter
    * precondition: battingorder must be instantiated, has to have at least one batter
    * postcondition: battter is removed
    * return: first batter
    * throws: nosuchelementexception if empty list
    ****************/
  public Batter dequeue() throws NoSuchElementException
  {
    return remove();
  }
  
  /********************
    * size - number of batters
    * precondition: battingorder must be instantiated
    * returns: number of batters in queue
    ****************/
  public int size()
  {
    return size();
  }
  
  
}