//imports
import java.lang.*;
import java.io.*;
import java.util.*;

/*******************************************
  * Batter Class
  * holds all information about a batter 
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 3 
  * @ Date:
  *      7/31/12
  **********************************************/

public class Batter
{
  //instance variables
  private String fname; 
  private String lname; 
  private int numbat;
  private int numhit;
  private double batave;
  private BooleanSource bs;
  
  /********************
    * constructor makes an instance of Batter
    * postcondition: sets all to basic values
    ****************/
  public Batter()
  {
    fname = "";
    lname = "";
    numbat = 0;
    numhit = 0;
    batave = 0.0;
  }
  
  /********************
    * constructor makes an instance of Batter
    * parameter: fn = first name string; ln = last name string;
    * bats = integer of number of times at bat
    * hits = integer of number of times hit the ball
    * ba = double of batting average 
    * postcondition: sets all to user defined values
    ****************/
  public Batter(String fn, String ln, int bats, int hits, double ba)
  {
    fname = fn;
    lname = ln;
    numbat = bats;
    numhit = hits;
    batave = ba;
  }
  
  /********************
    * setFirst - resets first name
    * parameter: fn = string first name
    * precondition: batter must be initialized, cant be null
    * postcondition: has a first name
    * throws: IllegalArguement  needs first name
    ****************/
  public void setFirst(String fn) throws IllegalArguement
  {
    if(fn == null)
      throw new IllegalArguement("Batter needs a first name");
    fname = fn;
  }
  
  /********************
    * getFirst - gets first name
    * precondition: batter must be initialized, cant be null
    * returns: string of first name
    ****************/
  public String getFirst()
  {
    return fname;
  }
  
  /********************
    * setLast - resets last name
    * parameter: ln = string last name
    * precondition: batter must be initialized, cant be null
    * postcondition: has a last name
    * throws: IllegalArguement  needs last name
    ****************/
  public void setLast(String ln) throws IllegalArguement
  {
    if(ln == null)
      throw new IllegalArguement("Batter needs a last name");
    lname = ln;
  }
  
  /********************
    * getLast - gets last name
    * precondition: batter must be initialized, cant be null
    * returns: string of last name
    ****************/
  public String getLast()
  {
    return lname;
  }
  
  /********************
    * setNumBat - resets num bats
    * parameter: nb = int number of bats
    * precondition: batter must be initialized, cant be null
    * postcondition: has batted that many times
    ****************/
  public void setNumBat(int nb)
  {
    numbat = nb;
  }
  
  /********************
    * getNumBat - gets number has batted
    * precondition: batter must be initialized, cant be null
    * returns: int of num bats
    ****************/
  public int getNumBat()
  {
    return numbat;
  }
  
  /********************
    * setNumHit - resets num hits
    * parameter: nh = int number of hits
    * precondition: batter must be initialized, cant be null
    * postcondition: has hitted that many times
    ****************/
  public void setNumHit(int nh)
  {
    numhit = nh;
  }
  
  /********************
    * getNumHit - gets number hits
    * precondition: batter must be initialized, cant be null
    * returns: int of num hits
    ****************/
  public int getNumHit()
  {
    return numhit;
  }
  
  /********************
    * setBatAve - resets batting average
    * parameter: ba = double number of batting average
    * precondition: batter must be initialized, cant be null
    * postcondition: has that batting average
    ****************/
  public void setBatAve(double ba)
  {
    batave = ba;
  }
  
  /********************
    * getBatAve - gets batting average
    * precondition: batter must be initialized, cant be null
    * returns: double of num bat average
    ****************/
  public double getBatAve()
  {
    return batave;
  }
  
  /********************
    * hit - figures if batter hit ball
    * precondition: batter must be initialized
    * postcondition: has that batting average
    * return: true if hit
    ****************/
  public boolean hit() throws IllegalArguement//from bs
  {
    //make sure there is bs
    bs = new BooleanSource(batave);
    return bs.query();
  }
  
  
}