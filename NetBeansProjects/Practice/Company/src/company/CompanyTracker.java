/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*******************************************
  * CompanyTracker Class
  * contains main method for company trees
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 4 
  * @ Date:
  *      8/7/12
  **********************************************/
public class CompanyTracker {
    /*********
    * the main method.
    * if the file company.obj exists in this directory, the tree will be initialized using 
    * serialization. else start with empty tree. 
    * menu will be displayed:
    * R = report a purchase
    * P = print info
    * D = display info about all companies
    * Q = quit
    * throws IllegalArguement - the numbers entered are incorrect
    ********/
  public static void main(String[] args) throws IllegalArguement
  {
    CompanyTree tree = new CompanyTree();
    boolean prevFile;
    try
    {
      //read object if there
      FileInputStream file = new FileInputStream("company.obj");
      ObjectInputStream instream = new ObjectInputStream(file);
      tree = (CompanyTree)instream.readObject();
      prevFile = true;
      //use same tree
    }
    catch(FileNotFoundException e)
    {
      System.out.println("There is no previous file.");
      prevFile = false;
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
      prevFile = false;
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("ClassNotFoundException was " + e.getMessage());
      prevFile = false;
    }
    
    String input = "";
    //buffer reader for input
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    if(prevFile == false)
    {
      //ask user to put in first company
      System.out.println("Enter the name of the first company: \n");
      try{
        input= in.readLine();
      }
      catch(IOException e)
      {
        System.out.println("IOException was " + e.getMessage());
      }
      tree = new CompanyTree(input);
    }
    
    //display menu
    System.out.println("R = report a purchase \nP = print info \nD = display info about all companies "
                         + "\nQ = quit\n Please note that capitalization does not matter.\n");
    try{
      input= in.readLine();
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    
    String newComp = "";
    String refComp = "";
    double price = 0.00;
    
    //while not q
    do
    {
      //report purchase
      if(input.equalsIgnoreCase("r"))
      {
        
        try{
          System.out.println("What is the new company's name? \n");
          newComp= in.readLine();
          System.out.println("What is the referring company's name? \n");
          refComp = in.readLine();
          System.out.println("What is the price of the purchase? \n");
          price = Double.parseDouble(in.readLine());
          
          //now try to purchase
          tree.reportPurchase(newComp, refComp, price);
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        catch(IllegalArguement e)
        {
          System.out.println("IllegalArguement was " + e.getMessage());
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
      
      //print info
      else if(input.equalsIgnoreCase("p"))
      {
        System.out.println("Choose the name of the company to print: \n");
        try{
          newComp = in.readLine();
          tree.printInformation(newComp);
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException g)
        {
          System.out.println("IOException was " + g.getMessage());
        }
      }
      
      //print all
      else if(input.equalsIgnoreCase("d"))
      {
        tree.displayAllInformation();
        System.out.println("");
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
      }
      
      //otherwise
      else if(!(input.equalsIgnoreCase("q")))
      {
        System.out.println("Choose a menu option: \n");
        try{
          input= in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
      }
      
    }while(!(input.equalsIgnoreCase("q")));
    System.out.println("Program terminating normally...");
    
    
    try
    {
      //save the tree into a file to be read again
      FileOutputStream file = new FileOutputStream("company.obj");
      ObjectOutputStream outstream = new ObjectOutputStream(file);
      //save obj in file
      outstream.writeObject(tree);
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
