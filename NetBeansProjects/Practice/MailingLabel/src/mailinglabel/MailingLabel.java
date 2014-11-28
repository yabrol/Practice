/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailinglabel;

import javax.swing.JOptionPane;

/**
 *
 * @author Yukti
 * //-----------------------------------------------------------------------
// MailingLabel.java              Author: Yukti Abrol
//
// Uses a delimiter to display a mailing label, correctly formatted.
//-----------------------------------------------------------------------

 */
public class MailingLabel
{
  
  public static void main (String [] args)
  {
    
    ////////////////////////////////////////////////////////
    
    // Mailing Label using scanner class in the interactions pane
    
    /*
    
    // instantiate scanner object
    Scanner scan = new Scanner(System.in);
    
    // declare string objects
    // yes holds 'y' to make another mailing label
    String delimiter, address, output;
    String yes = "y";
    
    // use dowhile loop  so method occurs at least once
    do
    {
      
      // ask user to enter delimiter
      System.out.println ("Enter the desired delimiter");
      // save input as delimiter object
      delimiter = scan.nextLine();
      
      
      // ask user to enter address
      System.out.println ("Enter address");
      // save input as address object
      address = scan.nextLine();
      
      // replace each delimiter with next line
      output = address.replace(delimiter, "\n");
      
      // print output mailing label
      System.out.println (output);
      
      // ask user if they want to do another mailing label
      System.out.println ("Do you want to make another mailing label? y/n");
      yes = scan.nextLine();
      // if user enters 'y', then repeat
    }while (yes.equalsIgnoreCase ("y"));
    
    */
    
    ///////////////////////////////////////////////////
    
    // Mailing Label using JOptionPane message dialogs
    
    // declare string objects
    String delimiter, address, output;
    
    // declare int object
    // again is to do again
    int again;
    
    //use dowhile loop so method occurs at least once
    do
    {
      
      // asks user to input delimiter & saves it in delimiter
      delimiter = JOptionPane.showInputDialog ("Enter the desired delimiter");
      // asks user to input address & saves it in address
      address = JOptionPane.showInputDialog ("Enter full address");
      
      // replace each delimiter with next line
      output = address.replace(delimiter, "\n");
      
      // display output mailing label in message box
      JOptionPane.showMessageDialog(null, output);
      
      //ask if user wants to input new mailing label
      again = JOptionPane.showConfirmDialog (null, "Do another mailing label?");
      //if user clicks YES, then repeat
    }while(again == JOptionPane.YES_OPTION);
    
    
  }
}




