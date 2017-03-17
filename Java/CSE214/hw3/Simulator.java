//imports
import java.lang.*;
import java.io.*;
import java.util.*;

/*******************************************
  * Simulator Class
  * simulates a baseball game
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 3 
  * @ Date:
  *      7/31/12
  **********************************************/

public class Simulator
{
  /*********
    * the main method. user enters locations of home and visitor data
    * throws IllegalArguement - the numbers entered are incorrect
    ********/
  public static void main(String[] args) throws IllegalArguement
  {
    //buffer reader for input
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //make tokenizer separate tokens by " "
    StringTokenizer tokener;
    
    //holds file path/name
    String homeFile = "";
    String visitFile = "";
    
    System.out.println("Welcome! \n You will be watching a simulation of" + 
                       " a baseball game. \n");
    System.out.println("Please enter the path for the home team file.");
    //read input
    try{
      homeFile= in.readLine();
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    System.out.println("Please enter the path for the visitor team file.");
    //read input
    try{
      visitFile= in.readLine();
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    
    String line = "";
    String input = "";
    Batter b;
    BattingOrder homeTeam = new BattingOrder();
    BattingOrder visitTeam = new BattingOrder();
    
    //buffer reader for home
    try{
      FileInputStream fs = new FileInputStream(homeFile);
      BufferedReader hin = new BufferedReader(new InputStreamReader(fs));
      //buffer reader for visitor
      FileInputStream fs2 = new FileInputStream(visitFile);
      BufferedReader vin = new BufferedReader(new InputStreamReader(fs2));
      
      //get data from home
      try{
        line = hin.readLine();
      }
      catch(IOException e)
      {
        System.out.println("IOException was " + e.getMessage());
      }
      int counter = 1;
      while(line != null && counter < 10)
      {
        b = new Batter();
        //each line is first, last, avg
        tokener = new StringTokenizer(line, " ");
        try{
          b.setFirst(tokener.nextToken());
        }
        catch(NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was: " + e.getMessage());
          System.out.println("There is no first name for home batter " + counter 
                               + "\n Please enter the first name.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException f)
          {
            System.out.println("IOException was " + f.getMessage());
          }
          b.setFirst(input);
        }
        try{
          b.setLast(tokener.nextToken());
        }
        catch(NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was: " + e.getMessage());
          System.out.println("There is no last name for home batter " + counter 
                               + "\n Please enter the last name.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException g)
          {
            System.out.println("IOException was " + g.getMessage());
          }
          b.setLast(input);
        }
        try
        {
          b.setBatAve(Double.parseDouble(tokener.nextToken()));
        }
        catch(NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was: " + e.getMessage());
          System.out.println("There is no batting average for home batter " + counter 
                               + "\n Please enter the batting average.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException h)
          {
            System.out.println("IOException was " + h.getMessage());
          }
          b.setBatAve(Double.parseDouble(input));
        }
        if(b.getBatAve() < 0.0 || b.getBatAve() >= 1.0)
        {
          System.out.println("This is not a valid batting average for home batter " + counter 
                               + "\n Please enter the batting average.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException e)
          {
            System.out.println("IOException was " + e.getMessage());
          }
          b.setBatAve(Double.parseDouble(input));
        }
        //hits and at bats are at 0
        //add to team
        homeTeam.enqueue(b);
        //go to next player
        try{
          line = hin.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        counter++;
      }
      
      //now do all that for visitor team
      try{
        line = vin.readLine();
      }
      catch(IOException e)
      {
        System.out.println("IOException was " + e.getMessage());
      }
      counter = 1;
      while(line != null && counter < 10)
      {
        b = new Batter();
        //each line is first, last, avg
        tokener = new StringTokenizer(line, " ");
        try{
          b.setFirst(tokener.nextToken());
        }
        catch(NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was: " + e.getMessage());
          System.out.println("There is no first name for bisitor batter " + counter 
                               + "\n Please enter the first name.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException q)
          {
            System.out.println("IOException was " + q.getMessage());
          }
          b.setFirst(input);
        }
        try{
          b.setLast(tokener.nextToken());
        }
        catch(NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was: " + e.getMessage());
          System.out.println("There is no last name for visitor batter " + counter 
                               + "\n Please enter the last name.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException w)
          {
            System.out.println("IOException was " + w.getMessage());
          }
          b.setLast(input);
        }
        try
        {
          b.setBatAve(Double.parseDouble(tokener.nextToken()));
        }
        catch(NoSuchElementException e)
        {
          System.out.println("NoSuchElementException was: " + e.getMessage());
          System.out.println("There is no batting average for visitor batter " + counter 
                               + "\n Please enter the batting average.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException z)
          {
            System.out.println("IOException was " + z.getMessage());
          }
          b.setBatAve(Double.parseDouble(input));
        }
        if(b.getBatAve() < 0.0 || b.getBatAve() >= 1.0)
        {
          System.out.println("This is not a valid batting average for visitor batter " 
                               + counter + "\n Please enter the batting average.");
          //read input
          try{
            input = in.readLine();
          }
          catch(IOException e)
          {
            System.out.println("IOException was " + e.getMessage());
          }
          b.setBatAve(Double.parseDouble(input));
        }
        //hits and at bats defaults 0
        //add to team
        visitTeam.enqueue(b);
        //go to next player
        try{
          line = vin.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        counter++;
      }
      
      //use counter for innings now
      counter = 1;
      String output = "";
      int hscore = 0;
      int vscore = 0;
      int outs;
      while( counter < 10)
      {
        //visitor first
        System.out.println("Top of inning " + counter + " :Visitor");
        outs = 0;
        while(outs < 3)
        {
          b = visitTeam.dequeue();
          output = b.getFirst() + " " + b.getLast() + "(" + b.getNumHit() + "/" +
            b.getNumBat() + ") :";
          //increment numHit and numBat
          b.setNumBat((b.getNumBat()+1));
          if(b.hit())
          {
            output = output + "Hit";
            b.setNumHit((b.getNumHit() + 1));
            vscore++;
          }
          else
          {
            outs++;
            output = output + "Out Number " + outs;
          }
          System.out.println(output);
          //add b to end
          visitTeam.enqueue(b);
        }
        System.out.println("\n");
        //display current score
        System.out.println("Score: Home - " + hscore + " Visitor - " + vscore + "\n");
        
        if ((counter != 9 && hscore < vscore))
        {
          //home second
          System.out.println("Bottom of inning " + counter + " :Home");
          outs = 0;
          while(outs < 3)
          {
            b = homeTeam.dequeue();
            output = b.getFirst() + " " + b.getLast() + "(" + b.getNumHit() + "/" +
              b.getNumBat() + ") :";
            //increment numHit and numBat
            b.setNumBat((b.getNumBat()+1));
            if(b.hit())
            {
              output = output + "Hit";
              b.setNumHit((b.getNumHit() + 1));
              hscore++;
            }
            else
            {
              outs++;
              output = output + "Out Number " + outs;
            }
            System.out.println(output);
            //add b to end
            homeTeam.enqueue(b);
          }
          System.out.println("\n");
          //display current score
          System.out.println("Score: Home - " + hscore + " Visitor - " + vscore + "\n");
        }
        counter++;
        
      }
      //game over
      if(hscore > vscore)
        System.out.println("Game Over! Home team wins: " + hscore + "-" + vscore);
      else if(vscore > hscore)
        System.out.println("Game Over! Visitor team wins: " + vscore + "-" + hscore);
      else
        System.out.println("Game Over! Tie Game: " + hscore + "-" + vscore);
      
      
      
    }
    catch(FileNotFoundException e)
    {
      System.out.println("FileNotFoundException was " + e.getMessage());
    }
    
  }
}