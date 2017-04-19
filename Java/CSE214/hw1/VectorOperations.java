///////////////////////////////////////////////
//     Yukti Abrol            108118904
//     CSE 214               HW 1 due 7/17/12
//////////////////////////////////////////////

/*******************************************
  * VectorOperations Class
  * tests methods of vectorADT class 
  * allows user to input long vectors as list of elements 
  * separated by spaces and perform operations on them
  **********************************************/
//imports
import java.util.StringTokenizer;
import java.lang.System;
import java.io.*;
import java.lang.Object;
import java.util.*;


public class VectorOperations
{
  /*********
    * main - displays a menu to
    * A -add
    * D - dot product
    * E - test for equality
    * M - multipy
    * S - subtract
    * Q - quit
    ************/
  
  public static void main(String[] args) throws IllegalArguement, InvalidSizeException
  {
    
    //buffer reader
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //make tokenizer separate tokens by " "
    StringTokenizer tokener;
    
    //declare vectorADT objs for later
    VectorADT v1;
    VectorADT v2;
    String vec = "";
    String input = "";
    
    //make menu and display
    String menu = " A) Add \n D) Dot Product \n E) Equality \n M) Multiply" 
      + "\n S) Subtract \n Q) Quit Program \n";
    System.out.print(menu);
    
    //read input
    try{
      input = in.readLine();
    }
    catch(IOException e)
    {
      System.out.println("IOException was " + e.getMessage());
    }
    
    //do while not quit
    do
    {
      //if/else since switch for string needs java7
      //equalsIgnoreCase used to avoid case sensitivity
      if(input.equalsIgnoreCase("a"))//add
      {
        System.out.print("You have chosen to add vectors. Enter the first vector: \n");
        //read v1
        try{
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v1 = new VectorADT(tokener.countTokens());
        //put each in v1
        for(int i = 0; i < v1.getSize(); i++)
        {
          v1.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        
        System.out.print("Enter the second vector: \n");
        //read v2
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v2 = new VectorADT(tokener.countTokens());
        //put each in v2
        for(int i = 0; i < v2.getSize(); i++)
        {
          v2.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        //print result
        System.out.print("   " + v1.toString() + "\n +  " + v2.toString() + "\n =  " 
                           + (VectorADT.add(v1,v2)).toString() + "\n");
        
        //get next option
        System.out.print(menu);
        
        //read input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
      }
      
      
      else if(input.equalsIgnoreCase("d"))//dotproduct
      {
        
        System.out.print("You have chosen to find the dot product of two vectors."
                           + "Enter the first vector: \n");
        //read v1
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v1 = new VectorADT(tokener.countTokens());
        //put each in v1
        for(int i = 0; i < v1.getSize(); i++)
        {
          v1.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        
        System.out.print("Enter the second vector: \n");
        //read v2
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v2 = new VectorADT(tokener.countTokens());
        //put each in v2
        for(int i = 0; i < v2.getSize(); i++)
        {
          v2.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        //print result
        System.out.print("   " + v1.toString() + "\n (dot product)  " + v2.toString() 
                           + "\n =  " + Integer.toString(VectorADT.dotProduct(v1,v2)) + "\n");
        
        //get next option
        System.out.print(menu);
        
        //read input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
      }
      
      else if(input.equalsIgnoreCase("e"))//equal
      {
        System.out.print("You have chosen to determine the equality of two vectors. Enter the first vector: \n");
        //read v1
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v1 = new VectorADT(tokener.countTokens());
        //put each in v1
        for(int i = 0; i < v1.getSize(); i++)
        {
          v1.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        
        System.out.print("Enter the second vector: \n");
        //read v2
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v2 = new VectorADT(tokener.countTokens());
        //put each in v2
        for(int i = 0; i < v2.getSize(); i++)
        {
          v2.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        //print result
        System.out.print("   " + v1.toString() + "\n =  " + v2.toString() + "\n ? \n  " 
                           + Boolean.toString(v1.equals(v2)) + "\n");
        
        //get next option
        System.out.print(menu);
        
        //read input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        
      }
      
      else if(input.equalsIgnoreCase("m"))//multiply
      {
        System.out.print("You have chosen to multiply a vector by a scalar. Enter the vector: \n");
        //read v1
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v1 = new VectorADT(tokener.countTokens());
        //put each in v1
        for(int i = 0; i < v1.getSize(); i++)
        {
          v1.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        
        System.out.print("Enter the scalar: \n");
        int scalar = 0;
        try
        {
          scalar = Integer.parseInt(in.readLine());
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        
        //print result
        System.out.print("   " + v1.toString() + "\n (*)  " + Integer.toString(scalar) + "\n =  " 
                           + (VectorADT.multiplyByScalar(v1,scalar)).toString() + "\n");
        
        //get next option
        System.out.print(menu);
        
        //read input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
      }
      
      else if(input.equalsIgnoreCase("s"))//subtract
      {
        System.out.print("You have chosen to find the difference of two vectors. Enter the first vector: \n");
        //read v1
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v1 = new VectorADT(tokener.countTokens());
        //put each in v1
        for(int i = 0; i < v1.getSize(); i++)
        {
          v1.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        
        System.out.print("Enter the second vector: \n");
        //read v2
        try
        {
          vec = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
        tokener = new StringTokenizer(vec, " ");
        //instantiate with # of tokens
        v2 = new VectorADT(tokener.countTokens());
        //put each in v2
        for(int i = 0; i < v2.getSize(); i++)
        {
          v2.setElement(Integer.parseInt(tokener.nextToken()),i);
        }
        //print result
        System.out.print("   " + v1.toString() + "\n -  " + v2.toString() + "\n =  " 
                           + (VectorADT.subtract(v1,v2)).toString() + "\n" );
        
        //get next option
        System.out.print(menu);
        
        //read input
        try{
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
      }
      
      else if(!input.equalsIgnoreCase("q"))//error
      {
        System.out.print("Please enter a valid option");
        try
        {
          input = in.readLine();
        }
        catch(IOException e)
        {
          System.out.println("IOException was " + e.getMessage());
        }
      }
      
    }while(input.equalsIgnoreCase("q") == false);
  }
}
