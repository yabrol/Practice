/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import javax.swing.JOptionPane;

/**
 *
 * @author Yukti
 * //-----------------------------------------------------------------------
// Palindrome.java              Author: Yukti Abrol
//
// Determines if inputted string is a palidrome.
//-----------------------------------------------------------------------

 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // declare variables to hold strings
    //input is string input, affirmative is yes, negative is no
    String input, affirmative, negative;
    
    //declare variables to hold integers
    //left is value of char on left, right is value of char on right, again is to do again
    int left, right, again;
    
    //initialize string variables to hold following strings
    affirmative = "This is a palidrome.";
    negative = "This is NOT a palidrome.";
    
    //use dowhile loop so method occurs at least once
    do
    {
      //asks user to input a string and saves it in input
      input = JOptionPane.showInputDialog ("Enter a string: ");
      //makes left equal 0 b/c 0 is the position of 1st char
      left = 0;
      //makes right equal the string length minus 1 b/c it's position of last char
      right = input.length() - 1;
      
      //make nested while loop
      //the value of the left and right chars are the same to make sure its same char
      //the value of left < value of right b/c it has to stop in the middle of the phrase
      //and if its odd # of chars, the middle 1 wont affect it
      while( input.charAt(left) == input.charAt(right) && left < right)
      {
        //left has to increase as it goes left to right & viceversa for right
        left++;
        right--;
      }
      
      //make ifelse block
      if(left < right)
        //show message that it is not palindrome
        JOptionPane.showMessageDialog(null, negative);
      else
        //show message that it is palindrome
        JOptionPane.showMessageDialog(null, affirmative);
      
      //ask if user wants to input new palindrome
      again = JOptionPane.showConfirmDialog (null, "Do another palindrome?");
      //if user clicks YES, then repeat
    }while(again == JOptionPane.YES_OPTION);
    }
    
}
