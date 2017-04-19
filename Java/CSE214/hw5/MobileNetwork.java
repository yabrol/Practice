//imports
import java.text.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.*;

/*******************************************
  * MobileNetwork Class
  * uses hash table to store names and assocated info in hash table
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 4 
  * @ Date:
  *      8/7/12
  **********************************************/

public class MobileNetwork 
{
  
  /*********
    * the main method.
    * if the file network.obj exists in this directory, the profiles will be 
    * initialized using serialization. else start with empty profiles.
    * menu will be displayed:
    * I = insert new user profile into table
    * D = delete user profile from table
    * U = update info for given profile
    * S = search if two users are within each other's mobile social network
    * Q = quit
    * throws IllegalArguement - the numbers entered are incorrect
    ********/
  public static void main(String[] args) throws IllegalArguement
  {
    Hashtable network = new Hashtable();
    
    try
    {
      //read object if there
      FileInputStream file = new FileInputStream("network.obj");
      ObjectInputStream instream = new ObjectInputStream(file);
      network = (Hashtable)instream.readObject();
      //use same table
    }
    catch(FileNotFoundException e)
    {
      System.out.println("There is no previous file.");
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("ClassNotFoundException was " + e.getMessage());
    }
    
    String input = "";
    //buffer reader for input
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    
    //display menu
    System.out.println("I = insert new user profile into table \n" +
                       "D = delete user profile from table \n" +
                       "U = update info for given profile \n" +
                       "S = search if two users are within each other's " + 
                       "mobile social network \n Q = quit\n " +
                       "Please note that capitalization does not matter.\n");
    try{
      input= in.readLine();
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    
    String input2 = "";
    String name = "";
    String name2 = "";
    int x = 0;
    int y = 0;
    Point loc;
    Point loc2;
    int nr = 1;
    int nr2 = 1;
    Profile p;
    Profile p2;
    //make tokenizer separate tokens by " "
    StringTokenizer tokener;
    
    //while not q
    do
    {
      //I = insert new user profile into table
      if(input.equalsIgnoreCase("I"))
      {
        //ask user for name loc and network range
        try{
          System.out.println("You will be adding a new profile \n");
          System.out.println("Enter the first name: \n");
          input2 = in.readLine();
          name = input2 + " ";
          System.out.println("Enter the last name: \n");
          input2 = in.readLine();
          name = name + input2;
          //make name all lowercase to ignore the case sensitivity issue later on
          name = name.toLowerCase();
          System.out.println("Enter the x y coordinate pair of the location" +
                             "(-100,100) as [x y]: \n");
          input2 = in.readLine();
          tokener = new StringTokenizer(input2, " ");
          if(tokener.hasMoreTokens())
            x = Integer.parseInt(tokener.nextToken());
          else
            throw new IllegalArguement("Need coordinates");
          if(tokener.hasMoreTokens())
            y = Integer.parseInt(tokener.nextToken());
          else
            throw new IllegalArguement("Need coordinates");
          System.out.println("Enter the preferred network range: \n");
          input2 = in.readLine();
          nr = Integer.parseInt(input2);
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
        catch(IllegalArguement f)
        {
          System.out.println("IllegalArguement was " + f.getMessage());
        }
        
        //check if entry is valid - no other same name
        //all keys are lowercase
        if (network.containsKey(name) == true)
        {
          System.out.println("Error: This person is already in the network.");
        }
        else //insert the new profile
        {
          try
          {
            p = new Profile(name, new Point(x,y), nr);
            network.put(name, p);
          }
          catch(IllegalArguement e)
          {
            System.out.println("IllegalArguement was " + e.getMessage());
          }
          catch(NullPointerException f)
          {
            System.out.println("NullPointerException was " + f.getMessage());
          }
        }
        
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
      }
      
      //D = delete user profile from table
      else if(input.equalsIgnoreCase("D"))
      {
        try{
          System.out.println("You will be deleting a profile \n");
          System.out.println("Enter the first name: \n");
          input2 = in.readLine();
          name = input2 + " ";
          System.out.println("Enter the last name: \n");
          input2 = in.readLine();
          name = name + input2;
          //again to lowercase to avoid case sensitivity
          name = name.toLowerCase();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
        //check to see if in hashtable
        //all keys are lowercase
        if (network.containsKey(name) == false)
        {
          System.out.println("Error: This person is not in the network.");
        }
        else //remove the person
        {
          network.remove(name);
        }
        
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
      }
      
      //U = update info for given profile 
      else if(input.equalsIgnoreCase("U"))
      {
        try{
          System.out.println("You will be updating a profile \n");
          System.out.println("Enter the first name: \n");
          input2 = in.readLine();
          name = input2 + " ";
          System.out.println("Enter the last name: \n");
          input2 = in.readLine();
          name = name + input2;
          //again to lowercase to avoid case sensitivity
          name = name.toLowerCase();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
        //check to see if in hashtable
        //all keys are lowercase
        if (network.containsKey(name) == false)
        {
          System.out.println("Error: This person is not in the network.");
        }
        else //remove the person
        {
          p = (Profile)network.get(name);
          //now ask user for updates:
          try{
            System.out.println("Enter the x y coordinate pair of the location" +
                               "(-100,100) as [x y]: \n");
            input2 = in.readLine();
            tokener = new StringTokenizer(input2, " ");
            if(tokener.hasMoreTokens())
              x = Integer.parseInt(tokener.nextToken());
            else
              throw new IllegalArguement("Need coordinates");
            if(tokener.hasMoreTokens())
              y = Integer.parseInt(tokener.nextToken());
            else
              throw new IllegalArguement("Need coordinates");
            System.out.println("Enter the preferred network range: \n");
            input2 = in.readLine();
            nr = Integer.parseInt(input2);
            p.setLocation(new Point(x,y));
            p.setNetworkRange(nr);
            //remove it so can update
            network.remove(name);
            //now put the fixed up person back in
            network.put(name, p);
          }
          catch(IOException f)
          {
            System.out.println("IOException was " + f.getMessage());
          }
          catch(IllegalArguement e)
          {
            System.out.println("IllegalArguement was " + e.getMessage());
          }
          catch(NullPointerException e)
          {
            System.out.println("NullPointerException was " + e.getMessage());
          }
          
        }
        
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
      }
      
      //S = search if two users are within each other's mobile social network
      else if(input.equalsIgnoreCase("S"))
      {
        try{
          System.out.println("You will be determining if two users are within" +
                             "each other's mobile social network \n");
          System.out.println("Enter the first name of the first person: \n");
          input2 = in.readLine();
          name = input2 + " ";
          System.out.println("Enter the last name of the first person: \n");
          input2 = in.readLine();
          name = name + input2;
          //again to lowercase to avoid case sensitivity
          name = name.toLowerCase();
          
          System.out.println("Enter the first name of the second person: \n");
          input2 = in.readLine();
          name2 = input2 + " ";
          System.out.println("Enter the last name of the second person: \n");
          input2 = in.readLine();
          name2 = name2 + input2;
          //again to lowercase to avoid case sensitivity
          name2 = name2.toLowerCase();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
        //check to see if in hashtable
        //all keys are lowercase
        if (network.containsKey(name) == false)
        {
          System.out.println("Error: This person, " + name +
                             ", is not in the network.");
        }
        else if (network.containsKey(name2) == false)
        {
          System.out.println("Error: This person, " + name2 +
                             ", is not in the network.");
        }
        else//both on network
        {
          //check if both mutally on each other's networks
          p = (Profile)network.get(name);
          p2 = (Profile)network.get(name2);
          loc = p.getLocation();
          loc2 = p2.getLocation();
          nr = p.getNetworkRange();
          nr2 = p2.getNetworkRange();
          
          if( (int)loc.distance(loc2) <= nr && (int)loc.distance(loc2) <= nr2)
          {
            System.out.println( name + " and " + name2 + " are in each other's"
                                 + " social network.");
          }
          else
          {
            System.out.println( name + " and " + name2 + " are NOT in each other's"
                                 + " social network.");
          }
        }
        
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
      }
      
      else if(!input.equalsIgnoreCase("q"))
      {
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException f)
        {
          System.out.println("IOException was " + f.getMessage());
        }
      }
    }while(!(input.equalsIgnoreCase("q")));
    System.out.println("Program terminating normally...");
    
    
    try
    {
      //save the tree into a file to be read again
      FileOutputStream file = new FileOutputStream("network.obj");
      ObjectOutputStream outstream = new ObjectOutputStream(file);
      //save obj in file
      outstream.writeObject(network);
    }
    catch(FileNotFoundException e)
    {
      System.out.println("There is no previous file.");
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    
  }
  
}