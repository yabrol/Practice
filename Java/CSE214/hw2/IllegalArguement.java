//imporst
import java.io.*;

/**************
  * IllegalArguement exceptions class for when the arguement isn't valid
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 2 
  * @ Date:
  *      7/24/12
  **************/


public class IllegalArguement extends Exception
{
  String error = "The position is not valid";
  //constructor
  public IllegalArguement()
  {
    super("The position is not valid");
  }
  //returns
  public IllegalArguement(String msg)
  {
    super(msg);
    error = msg;
  }
  //return message
  public String getMessage()
  {
    return error;
  }
  
}