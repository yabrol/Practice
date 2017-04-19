///////////////////////////////////////////////
//     Yukti Abrol            108118904
//     CSE 214               HW 1 due 7/17/12
//////////////////////////////////////////////

//imporst
import java.io.*;

//InvalidSizeException exceptions class


public class InvalidSizeException extends Exception
{
  //constructor
  public InvalidSizeException()
  {
    super("This is the wrong size.");
  }
  //returns
  public InvalidSizeException(String msg)
  {
    super(msg);
  }
  
}