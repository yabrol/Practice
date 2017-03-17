/*******************************************
  * BooleanSource Class
  * returns true or false based on a probabilty 
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 3 
  * @ Date:
  *      7/31/12
  **********************************************/

public class BooleanSource
{
  //variable holding probability
  private double prob;
  
  /********************
    * constructor makes an instance of BooleanSource
    * parameter: p = double that holds probability
    * precondition: p cannot be null, <0 or >1
    * throws: IllegalArguement
    ****************/
  public BooleanSource(double p) throws IllegalArguement
  {
    if(p < 0.0 || p >= 1.0)
      throw new IllegalArguement("The probability is not valid.");
    prob = p;
  }
  
  /********************
    * query - returns true prob amount of the time
    * precondition: booleansource must be instantiated
    * return: true prob amount of the time and false otherwise
    ****************/
  public boolean query()
  {
    return(Math.random() < prob);
  }
  
}