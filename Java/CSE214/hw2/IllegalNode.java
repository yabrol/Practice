//imports
import java.io.*;

/**************
  * IllegalNode exceptions class for when the node isn't valid
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 2 
  * @ Date:
  *      7/24/12
  **************/


public class IllegalNode extends Exception
{
  String error = "The node is not valid";
  //constructor
  public IllegalNode()
  {
    super("The node is not valid");
  }
  //returns userdefined
  public IllegalNode(String msg)
  {
    super(msg);
    error = msg;
  }
  //returns message
  public String getMessage()
  {
    return error;
  }
  
}