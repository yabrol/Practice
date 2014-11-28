/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.io.Serializable;

/**************
  * IllegalArguement exceptions class for when the arguement isn't valid
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 4
  * @ Date:
  *      8/7/12
  **************/


public class IllegalArguement extends Exception implements Serializable
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