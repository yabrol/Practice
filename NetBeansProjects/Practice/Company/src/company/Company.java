/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.io.Serializable;

/*******************************************
  * Company Class
  * holds all information about a company 
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 4 
  * @ Date:
  *      8/7/12
  **********************************************/
public class Company implements Serializable{

    //variables
  private String name;
  private double purchase;
  private double commission;
  private double sales;
  private Company referrer;
  
  /********************
    * constructor makes an instance of Company
    * postcondition: sets all to basic values
    ****************/
  public Company()
  {
    name = "";
    purchase = Double.NaN;
    commission = Double.NaN;
    sales = Double.NaN;
    referrer = null;
  }
  
  /********************
    * constructor makes an instance of Company
    * parameter: n = name of company
    * postcondition: sets all to basic values
    ****************/
  public Company(String n)
  {
    name = n;
    purchase = Double.NaN;
    commission = Double.NaN;
    sales = Double.NaN;
    referrer = null;
  }
  
  /********************
    * setName - resets company name
    * parameter: n = string of name
    * precondition: company must be initialized, cant be null
    * postcondition: has a first name
    * throws: IllegalArguement  needs first name
    ****************/
  public void setName(String n) throws IllegalArguement
  {
    if(n == null)
      throw new IllegalArguement("Company needs a name");
    name = n;
  }
  
  /********************
    * getName - gets company name
    * precondition: company must be initialized, cant be null
    * returns: string of name
    ****************/
  public String getName()
  {
    return name;
  }
  
  /********************
    * setPurchase - resets company purchase
    * parameter: p = double of purchase
    * precondition: company must be initialized, cant be null
    * postcondition: has a purchase
    ****************/
  public void setPurchase(double p) 
  {
    purchase = p;
  }
  
  /********************
    * getPurchase - gets latest purchase
    * precondition: company must be initialized, cant be null
    * returns: double of purchase
    ****************/
  public double getPurchase()
  {
    return purchase;
  }
  
  /********************
    * setCommission - resets company commission
    * parameter: c = double of commission
    * precondition: company must be initialized, cant be null
    * postcondition: has a commission
    ****************/
  public void setCommission(double c) 
  {
    commission = c;
  }
  
  /********************
    * getCommission - gets total commission
    * precondition: company must be initialized, cant be null
    * returns: double of commission
    ****************/
  public double getCommission()
  {
    return commission;
  }
  
  /********************
    * setSales - resets company sales
    * parameter: s = double of sales
    * precondition: company must be initialized, cant be null
    * postcondition: has a sales
    ****************/
  public void setSales(double s) 
  {
    sales = s;
  }
  
  /********************
    * getSales - gets total sales
    * precondition: company must be initialized, cant be null
    * returns: double of sales
    ****************/
  public double getSales()
  {
    return sales;
  }
  
  /********************
    * setReferrer - resets company referrer
    * parameter: c = Company of referrer
    * precondition: company must be initialized, cant be null
    * postcondition: has a referrer
    ****************/
  public void setReferrer(Company c) 
  {
    referrer = c;
  }
  
  /********************
    * getReferrer - gets total referrer
    * precondition: company must be initialized, cant be null
    * returns: Company of referrer
    ****************/
  public Company getReferrer()
  {
    return referrer;
  }
  
  
}
