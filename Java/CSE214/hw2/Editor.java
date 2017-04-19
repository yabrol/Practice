//imports
import java.util.*;
import java.io.*;
import java.lang.*;

/************
  * A driver used to test LineList.
  * The user inputs the following to perform actions:
  * A <number of lines> - appends one or more lines at end of text
  * H - displays help menu
  * I <number of lines>- inserts one or more lines before current line
  * L <startingLine> <endingLine>- prints lines and moves 
  *      current line to specific position
  * N - moves to next line and prints
  * P - moves to previous line and prints
  * R - removes current line
  * Q - quit
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 2 
  * @ Date:
  *      7/24/12
  ***************/

public class Editor
{
  /*********
    * the main method. user enters the data and then can modify as needed
    * based on predefined commands. 
    * throws IllegalArguement - the numbers entered are incorrect
    * throws IllegalNode - the node entered is invalid
    ********/
  
  public static void main(String[] args) //throws IllegalArguement,  IllegalNode
  {//exceptions from linenode and linelist methods
    //buffer reader
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //make tokenizer separate tokens by " "
    StringTokenizer tokener;
    //make linelist
    LineList myList = new LineList();
    //make lineNode for later
    LineNode curr = myList.getCursor();
    //user input
    String input = "";
    //help menu
    String helpmenu = "Help Menu: \n"
      + "A <number of lines> - appends one or more lines at end of text \n" +
      "H - displays help menu \n" + "I <number of lines>- inserts one or more lines"
      + "before current line \n" + "L <startingLine> <endingLine>- prints lines and moves"
      + "current line to specific position \n" + "N - moves to next line and prints \n"
      + "P - moves to previous line and prints \n" + "R - removes current line \n"
      + "Q - quit \n";
    
    System.out.println(helpmenu);
    //read input
    try{
      input = in.readLine();
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    String checkme;
    tokener = new StringTokenizer(input, " ");
    checkme = tokener.nextToken();
    
    
    while(!checkme.equalsIgnoreCase("q"))
    {
      if(checkme.equalsIgnoreCase("a"))//append
      {
        System.out.println("You will append the lines to the end");
        try{
          int numLines = Integer.parseInt(tokener.nextToken());
          //add each line to end. cursor = newest one added
          for(int i = 0; i < numLines; i++)
          {
            System.out.println("Enter the line" + (1+i));
            try{
              input = in.readLine();
            }
            catch(IOException e)
            {
              System.out.println("IOException was " + e.getMessage());
            }
            myList.append(input);
            curr = myList.getCursor();
          }
        }
        catch (NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was " + e.getMessage());
          System.out.println("You entered something wrong. Choose another option");
        }
        //get next input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
      
      else if(checkme.equalsIgnoreCase("h"))//help
      {
        System.out.println(helpmenu);
        //get next input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
      
      else if (checkme.equalsIgnoreCase("i"))//insert
      {
        System.out.println("You will append the lines before the cursor");
        try
        {
          int numLines = Integer.parseInt(tokener.nextToken());
          //add each line to end.
          for(int i = 0; i < numLines; i++)
          {
            System.out.println("Enter the line" + i);
            try{
              input = in.readLine();
            }
            catch(IOException e)
            {
              System.out.println("IOException was " + e.getMessage());
            }
            myList.insertBeforeCursor(input);
          }
        }
        catch (NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was " + e.getMessage());
          System.out.println("You entered something wrong. Choose another option");
        }
        //get next input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
      
      else if(checkme.equalsIgnoreCase("l"))//print
      {
        System.out.println("You will be printing a selection of lines");
        try
        {
          int startLine = Integer.parseInt(tokener.nextToken());
          int endLine = Integer.parseInt(tokener.nextToken());
          //print each line
          curr = myList.printList(startLine, endLine);
        }
        catch (NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was " + e.getMessage());
          System.out.println("You entered something wrong. Choose another option");
        }
        catch( IllegalArguement e)
        {
          System.out.println("IllegalArguement was " + e.getMessage());
          System.out.println("You entered something wrong. Choose another option");
        }
        
        //get next input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
      
      else if(checkme.equalsIgnoreCase("n"))//next
      {
        System.out.println("You will be printing and moving to the next line.");
        try{
          String msg = myList.nextLine();
          //check if null
          if (msg == null)
          {
            System.out.println("There is no next line. Choose another option.");
          }
          else
          {
            System.out.println(msg);
            curr = myList.getCursor();
          }
        }
        catch (IllegalNode e)
        {
          System.out.println("IllegalNode was " + e.getMessage());
          System.out.println("There is no next line. Choose another option.");
        }
        //get next input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
      else if(checkme.equalsIgnoreCase("p"))//prev
      {
        System.out.println("You will be printing and moving to the previous line.");
        try{
          String msg = myList.previousLine();
          //check if null
          if (msg == null)
          {
            System.out.println("There is no previous line. Choose another option.");
          }
          else
          {
            System.out.println(msg);
            curr = myList.getCursor();
          }
        }
        catch (IllegalNode e)
        {
          System.out.println("IllegalNode was " + e.getMessage());
          System.out.println("There is no previous line. Choose another option.");
        }
        //get next input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
      
      else if(checkme.equalsIgnoreCase("r"))//remove
      {
        boolean alpha = myList.removeCursor();
        if (alpha == false)
        {
          System.out.println("There is no text to remove. Choose another option");
        }
        try
        {
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
      else if(!(checkme.equalsIgnoreCase("q")))//error
      {
        System.out.println("Please enter a valid option");
        try
        {
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(input, " ");
        checkme = tokener.nextToken();
      }
      
    }
    
  }
  
}
