/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.io.Serializable;

/*******************************************
  * CompanyNode Class
  * a BST node containing a company object
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 4 
  * @ Date:
  *      8/7/12
  **********************************************/
public class CompanyNode implements Serializable{
    //variables
  private Company comp;
  private CompanyNode right;
  private CompanyNode left;
  
  /********************
    * constructor makes an instance of CompanyNode
    * postcondition: sets all to basic values
    ****************/
  public CompanyNode()
  {
    comp = null;
    right = null;
    left = null;
  }
  
  /********************
    * constructor makes an instance of CompanyNode
    * parameter: c = company
    * postcondition: sets all to basic values
    ****************/
  public CompanyNode(Company c)
  {
    comp = c;
    right = null;
    left = null;
  }
  
  
  /********************
    * setCompany - resets company
    * parameter: c =  company
    * precondition: companynode must be initialized, cant be null
    * postcondition: has a company
    ****************/
  public void setCompany(Company c) 
  {
    comp = c;
  }
  
  /********************
    * getCompany - gets company
    * precondition: companynode must be initialized, cant be null
    * returns: company
    ****************/
  public Company getCompany()
  {
    return comp;
  }
  
  /********************
    * setLeft - resets left
    * parameter: l =  left companynode
    * postcondition: has a left
    ****************/
  public void setLeft(CompanyNode l) 
  {
    left = l;
  }
  
  /********************
    * getLeft - gets left companynode
    * returns: left
    ****************/
  public CompanyNode getLeft()
  {
    return left;
  }
  
  /********************
    * setRight - resets right
    * parameter: r =  right companynode
    * postcondition: has a right
    ****************/
  public void setRight(CompanyNode r) 
  {
    right = r;
  }
  
  /********************
    * getRight - gets right company node
    * returns: right
    ****************/
  public CompanyNode getRight()
  {
    return right;
  }
}
