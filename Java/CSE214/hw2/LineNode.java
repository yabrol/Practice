/*******************************************
  * LineNode Class
  * contains line (String) and references to prev 
  * and next LineNode instances. 
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 2 
  * @ Date:
  *      7/24/12
  **********************************************/

public class LineNode 
{
  //variables
  private String msg;//holds the string in this node
  private LineNode prev; //refers to previous LineNode
  private LineNode nxt; //refers to next LineNode
  
  
  
  /********************
    * constructor makes an instance of LineNode
    * parameter: str = String that this contains
    * precondition: str cannot be null
    * postcondition: does not point to any other nodes yet
    ****************/
  public LineNode (String str) 
  {
    //save the string
    msg = str;
    //not pointing to anything yet
    prev = null;
    nxt = null;
  }
  
    /********************
    * setLine - resets string to line
    * parameter: line = String that this contains
    * precondition: str cannot be null, LineNode must be instantiated
    ****************/
  public void setLine(String line) 
  {
    //save string
    msg = line;
  }
  
    /********************
    * getLine - gets the message
    * precondition: linenode must be instantiated
    * returns: line
    ****************/
  public String getLine()
  {
    return msg;
  }
  
    /********************
    * setNext - resets next linenode
    * parameter: node = linenode that is after this
    * precondition: node  must be instantiated
    * postcondition: this points to node
    ****************/
  public void setNext(LineNode node) 
  {
    nxt = node;
  }
  
  /********************
    * setPrev - resets previous linenode
    * parameter: node = linenode that is before this
    * precondition: node must be instantiated
    * postcondition: this points to node
    ****************/
  public void setPrev(LineNode node) 
  {
    prev = node;
  }
  
  /********************
    * getNext returns the next linenode
    * precondition: must be instantiated
    * return: next node or null if none
    ****************/
  public LineNode getNext()
  {
    return nxt;
  }
  
    /********************
    * getPrev returns the previous linenode
    * precondition: must be instantiated
    * return: prev node or null if none
    ****************/
  public LineNode getPrev()
  {
    return prev;
  }
   
}