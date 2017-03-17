import java.text.*;
import java.io.*;
import java.awt.*;
/*******************************************
  * Profile Class
  * holds all information about a person: name, location, network range
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 4 
  * @ Date:
  *      8/7/12
  **********************************************/

public class Profile implements Serializable
{
  //variables
  private String name;
  private Point loc;
  private int netRange;
  private boolean setL = false;
  private final int MIN = -100;
  private final int MAX = 100;
  
  /********************
    * constructor makes an instance of Profile
    * postcondition: sets all to basic values
    ****************/
  public Profile()
  {
    name = "";
    loc = new Point();
    netRange = 1;
  }
  
  /********************
    * constructor makes an instance of Company
    * parameter: n = name of company; 
    * l = point of location; nr = int of network range
    * postcondition: sets all to basic values
    ****************/
  public Profile(String n, Point l, int nr) throws IllegalArguement
  {
    if(n == null)
      throw new IllegalArguement("Profile needs a name");
    if(l == null)
      throw new IllegalArguement("Profile needs a location");
    //if(setL == true)
    //  throw new IllegalArguement("Cannot change location");
    if(l.getX() > MAX || l.getX() < MIN || l.getY() > MAX || l.getY() < MIN)
      throw new IllegalArguement("Location has to be between " + MIN + " and " + MAX);
    if(nr < 1)
      throw new IllegalArguement("Profile needs a positive range");
    name = n;
    loc = l;;
    netRange = nr;
    setL = true;
  }
  
  /********************
    * setName - resets profile name
    * parameter: n = string of name
    * precondition: profile must be initialized, cant be null
    * postcondition: has a name
    * throws: IllegalArguement  needs name
    ****************/
  public void setName(String n) throws IllegalArguement
  {
    if(n == null)
      throw new IllegalArguement("Profile needs a name");
    name = n;
  }
  
  /********************
    * getName - gets profile name
    * precondition: profile must be initialized, cant be null
    * returns: string of name
    ****************/
  public String getName()
  {
    return name;
  }
  
  /********************
    * setLocation - resets profile location
    * parameter: l = point of location
    * precondition: profile must be initialized, cant be null
    * postcondition: has a location
    * throws: IllegalArguement needs location; has to between -100 to 100
    ****************/
  public void setLocation(Point l) throws IllegalArguement
  {
    if(l == null)
      throw new IllegalArguement("Profile needs a location");
    //if(setL == true)
    //  throw new IllegalArguement("Cannot change location");
    if(l.getX() > MAX || l.getX() < MIN || l.getY() > MAX || l.getY() < MIN)
      throw new IllegalArguement("Location has to be between " + MIN + " and " + MAX);
    loc = l;
    setL = true;
  }
  
  /********************
    * getLocation - gets profile location
    * precondition: profile must be initialized, cant be null
    * returns: point of location
    ****************/
  public Point getLocation()
  {
    return loc;
  }
  
  /********************
    * setName - resets profile network range
    * parameter: nr = network range int
    * precondition: profile must be initialized, cant be null
    * postcondition: has a network range
    * throws: IllegalArguement needs to be positive number
    ****************/
  public void setNetworkRange(int nr) throws IllegalArguement
  {
    if(nr < 1)
      throw new IllegalArguement("Profile needs a positive range");
    netRange = nr;
  }
  
  /********************
    * getName - gets profile network range
    * precondition: profile must be initialized, cant be null
    * returns: int of network range
    ****************/
  public int getNetworkRange()
  {
    return netRange;
  }
  
  
  /*******************************
    * Question 3:
    * a) When the table is automatically resized, 
    * newTableLength = 2 * oldTableLength + 1
    * 
    * b) The collisions are put in a list and then it 
    * is searched through the list if that key is used til 
    * data is found or the data does not exist
    * 
    * c) Serialization allows the program to read directly 
    * from a binary file. This is faster than reading from a
    * text file because if it is read from the text file
    * extra operations have to be implemented.
    * First, a file reader has to be made and the stream
    * has to be connected. Then each line has to be read,
    * and each line has to be converted to the relative
    * part of the object that is necessary for the object to
    * be complete. Everytime a command in a high-level
    * language is implemented, it has to be converted to
    * binary for the computer to understand, and then after
    * the operations are completed, it has to be
    * converted back to either the high-level language or
    * as the output. Serialization gives the binary file so
    * all those steps can be skipped.
    ******************************/
  
}