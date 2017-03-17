///////////////////////////////////////////////
//     Yukti Abrol            108118904
//     CSE 214               HW 1 due 7/17/12
//////////////////////////////////////////////

//imporst
import java.io.*;

//IllegalArguement exceptions class


public class IllegalArguement extends Exception
{
  //constructor
  public IllegalArguement()
  {
    super("The position is not valid");
  }
  //returns
  public IllegalArguement(String msg)
  {
    super(msg);
  }
  
}