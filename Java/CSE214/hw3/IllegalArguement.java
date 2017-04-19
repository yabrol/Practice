//imporst
import java.io.*;

/**************
  * IllegalArguement exceptions class for when the arguement isn't valid
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 3
  * @ Date:
  *      7/31/12
  **************/


public class IllegalArguement extends Exception
{
  String error = "The arguement is not valid";
  //constructor
  public IllegalArguement()
  {
    super("The arguement is not valid");
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