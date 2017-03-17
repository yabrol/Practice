//imports
import java.lang.*;
import java.io.*;
import java.util.*;


/*******************************************
  * LineList Class
  * is a list of LineNodes.
  * It contains references to head, tail, cursor LineNode
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 2 
  * @ Date:
  *      7/24/12
  **********************************************/
public class LineList
{
  //variables
  private LineNode head;
  private LineNode tail;
  private LineNode cursor;
  //to not remake everytime
  private LineNode curr;
  private LineNode newNode;
  
  /********************
    * constructor makes an instance of LineList
    * postcondition: does not point to any other nodes yet, is empty list
    ****************/
  public LineList () 
  {
    head = null;
    tail = null;
    cursor = null;
  }
  
  /**********************
    * insertBeforeCursor
    * inserts linenode before cursor node
    * parameter: line = str of linenode
    * return: false if empty (no insertion), true otherwise
    **********************/
  public boolean insertBeforeCursor(String line) 
  {
    if (cursor == null)
      return false;
    //make new node
    newNode = new LineNode(line);
    //go to before cursor
    curr = head;
    while(curr != cursor)
    {
      curr = curr.getNext();
    }
    //put newNode in list
    curr.setNext(newNode);
    newNode.setNext(cursor);
    newNode.setPrev(curr);
    cursor.setPrev(newNode);
    return true;
  }
  
  /**********************
    * append inserts linenode after tail
    * parameter: line = str of linenode
    * postcondition: inserts line after tail
    **********************/
  public void append(String line) 
  {
    newNode = new LineNode(line);
    //if empty, set all to newnode
    if (tail == null)
    {
      head = newNode;
      tail = newNode;
      cursor = newNode;
    }
    else
    {
      tail.setNext(newNode);
      newNode.setPrev(tail);
      newNode.setNext(null);
      cursor = newNode;
      tail = newNode;
    }
  }
  
  /*************
    * removeCursor removes cursor node
    * postcondition: cursor is the node before the removed one
    * return: false if no cursor, true else
    ***************/
  public boolean removeCursor() 
  {
    if (cursor == null)
      return false;
    else
    {
      curr = cursor.getPrev();
      curr.setNext(cursor.getNext());
      cursor.getNext().setPrev(curr);
      cursor = curr;
      return true;
    }
  }
  
  /***********
    * nextLine returns string of next line and moves cursor to next line
    * precondition: cursor != null
    * postcondition: cursor is next node
    * return: string of next line
    * throw: cursor not available
    ************/
  
  public String nextLine() throws IllegalNode
  {
    if (cursor == null)
      throw new IllegalNode();
    if (cursor == tail)
      return null;
    cursor = cursor.getNext();
    return cursor.getLine();
  }
  
  /***********
    * previousLine returns string of previous line and moves cursor to previous line
    * precondition: cursor != null
    * postcondition: cursor is previous node
    * return: string of next line
    * throw: cursor not available
    ************/
  public String previousLine() throws IllegalNode
  {
    if (cursor == null)
      throw new IllegalNode();
    if (cursor == head)
      return null;
    cursor = cursor.getPrev();
    return cursor.getLine();
  }
  
  /***************
    * cursorLineNo returns the position of the cursor
    * return: position of cursor
    **************/
  public int cursorLineNo()
  {
    if (cursor == null)
      return 0;
    curr = head;
    //counter
    int i = 1;
    while(curr != cursor)
    {
      curr = curr.getNext();
      i++;
    }
    return i;
  }
  
  /**************
    * printCursor prints the cursor number followed by the message
    * postcondition: prints cursor # followed by string
    ******************/
  public void printCursor()
  {
    String str = Integer.toString(cursorLineNo());
    //empty
    if (str == "0")
    {
      System.out.print( str + "\t" + "NULL - EMPTY LIST");
    }
    else
    {
      System.out.print( str + "\t" + cursor.getLine());
    }
  }
  
  /**************
    * printCursor2 prints the cursor number followed by the message into a string
    * returns: string containing cursor # followed by message
    ******************/
  public String printCursor2()
  {
    String str = Integer.toString(cursorLineNo());
    //empty
    if (str == "0")
    {
      return( str + "\t" + "NULL - EMPTY LIST");
    }
    else
    {
      return( str + "\t" + cursor.getLine());
    }
  }
  
  
  /***********
    * printList prints all the lines from the specified lines
    * precondition: startingLine < endingLine
    * postcondition: cursor at endingLine; prints each line from startingline to endingline
    * return: cursor
    * throws IllegalArguement: wrong numbers
    **************/
  public LineNode printList(int startingLine, int endingLine) throws IllegalArguement
  {
    //if numbers placed wrong
    if (endingLine < startingLine)
      throw new IllegalArguement();
    //if numbers dont exist with current linelist
    curr = cursor;
    cursor = tail;
    if( startingLine > cursorLineNo())
      throw new IllegalArguement();
    cursor = curr;
    //holds current line number
    int curnum = cursorLineNo();
    //move cursor back
    if (startingLine < curnum)
    {
      while(curnum!=startingLine)
      {
        cursor = cursor.getPrev();
        curnum--;
      }
    }
    //move cursor forward
    if (startingLine > curnum)
    {
      while(curnum!=startingLine)
      {
        cursor = cursor.getNext();
        curnum++;
      }
    }
    //now cursor is at starting line
    while(curnum<=endingLine && curnum!= 0)
    {
      System.out.print (printCursor2());
      System.out.print("\n");
      cursor = cursor.getNext();
      curnum++;
    }
    return cursor;
  }
  
  /*********
    * getCursor returns the cursor
    *************/
  public LineNode getCursor()
  {
    return cursor;
  }
  
  
  
}