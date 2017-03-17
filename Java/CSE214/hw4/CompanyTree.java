import java.text.*;
import java.io.*;
/*******************************************
  * CompanyTree Class
  * a collection of companyNodes stored in a BST with company name used as search key
  * @ author
  *    Yukti Abrol    108118904
  * @ Assignment
  *     Homework 4 
  * @ Date:
  *      8/7/12
  **********************************************/
public class CompanyTree implements Serializable
{
  //variables
  private CompanyNode root;
  
  
  /********************
    * constructor makes an instance of CompanyTree
    * parameter: String firstCompanyName = name of first company
    * postcondition: sets all to basic values
    ****************/
  public CompanyTree(String firstCompanyName)
  {
    Company c = new Company(firstCompanyName);
    root = new CompanyNode(c);
  }
  
  /********************
    * constructor makes an instance of CompanyTree
    * postcondition: sets all to basic values
    ****************/
  public CompanyTree()
  {
    root = null;
  }
  
  
  /********************
    * reportPurchase - adds new company in correct position and updates tree
    * parameter: newCompany = string name of new company
    * referringCompany = string name of referring company
    * price = double priceof purchase
    * precondition: companyTree is instantiated, no arguement is null
    * postcondition: puts the new company in the correct position
    * also updates the companies that were affected by this purchase
    * throws: IllegalArguement = newCompany is already in tree, referringCompany is
    * not in tree, or price <= 0.00
    ****************/
  public void reportPurchase(String newCompany, String referringCompany, double price) 
    throws IllegalArguement
  {
    //if price <=0.00
    if (price <= 0.00)
      throw new IllegalArguement("The price must be greater than $0.00");
    Company nC = new Company(newCompany);
    CompanyNode nCN = new CompanyNode(nC);
    CompanyNode cur;
    boolean done = false;
    boolean refcomp = false;
    CompanyNode ref = new CompanyNode();
    
    cur = root;
    //if newCompany already exists
    if (cur.getCompany().getName().equalsIgnoreCase(newCompany))
      throw new IllegalArguement("The new company already exists and"
                                   + " there is no referring company.");
    
    while(!done)
    {
      //if root is referringCompany
      if(cur.getCompany().getName().equalsIgnoreCase(referringCompany))
      {
        ref = cur;
        refcomp = true;
      }
      //look on left side
      if(newCompany.compareToIgnoreCase(cur.getCompany().getName()) < 0)
      {
        if(cur.getLeft() == null)
        {
          //insert
          cur.setLeft(nCN);
          done = true;
        }
        else cur = cur.getLeft();
        //check if cur is ref comp
        if (cur.getCompany().getName().equalsIgnoreCase(referringCompany))
        {
          ref = cur;
          refcomp = true;
        }
      }
      //look on right side
      else if(newCompany.compareToIgnoreCase(cur.getCompany().getName()) > 0)
      {
        if(cur.getRight() == null)
        {
          //insert
          cur.setRight(nCN);
          done = true;
        }
        else cur = cur.getRight();
        //check if cur is ref comp
        if (cur.getCompany().getName().equalsIgnoreCase(referringCompany))
        {
          ref = cur;
          refcomp = true;
        }
      }
      //else we hit the same company
      else if(newCompany.compareToIgnoreCase(cur.getCompany().getName()) == 0)
      {
        throw new IllegalArguement("The new company already exists.");
      }
    }
    
    //check if referring company exists
    if(refcomp == false)
    {
      try{
        //remove company
        if (cur.getLeft().getCompany().getName().equalsIgnoreCase(newCompany))
          cur.setLeft(null);
        else if (cur.getRight().getCompany().getName().equalsIgnoreCase(newCompany))
          cur.setRight(null);
      }
      catch(NullPointerException e)
      {
        String notetoself = "turns out it didnt get inserted accidently";
      }
      throw new IllegalArguement("There is no referring company.");
    }
    
    //make referrer
    nC.setReferrer(ref.getCompany());
    
    //insertion successful -> update other companies
    int counter = 1;
    CompanyNode refN = ref;
    Company ref2 = ref.getCompany();
    double com = 0.00;
    double remainder = price;
    
    //set purchase of new
    nC.setPurchase(price);
    nC.setSales(0.00);
    nC.setCommission(0.00);
    cur = nCN;
    //set sales and commission. sales is remainder after subtracting commission
    while(!(ref2.getReferrer() == null )&& counter < 5)
    {
      //price is what ref gets added to sales
      //nC = newcompany nCN = newcompanynode
      cur = ref;
      ref2 = cur.getCompany().getReferrer();
      refN = new CompanyNode(ref2);
      
      com = price * (counter * .05);
      if((new Double(ref2.getCommission())).equals(Double.NaN))
      {
        ref2.setCommission(0.00);
      }
      ref2.setCommission(ref2.getCommission() + com);
      remainder = remainder - com;
      
      counter++;
    }
    if((new Double(nC.getReferrer().getSales())).equals(Double.NaN))
    {
      nC.getReferrer().setSales(0.00);
    }
    nC.getReferrer().setSales(nC.getReferrer().getSales() + remainder);
    if ((new Double(nC.getReferrer().getCommission())).equals(Double.NaN))
    {
      nC.getReferrer().setCommission(0.00);
    }
  }
  
  /********************
    * printInformation - prints info about the company if in tree
    * parameter: company = string name of company
    * postcondition: prints name, referring company (if applicable), original purchase price
    * (if not NaN), sales generated, commission generated, total revenue generated 
    * (sales + commission)
    ****************/
  public void printInformation(String company) 
  {
    //find company
    Company comp;
    CompanyNode cur = root;
    boolean done = false;
    //if empty
    if(cur == null)
    {
      System.out.println("There are no companies in this tree.");
      return;
    }
    else
    {
      try{
        while(!done)
        {
          //if cur = company
          if(company.compareToIgnoreCase(cur.getCompany().getName()) == 0)
          {
            done = true;
            comp = cur.getCompany();
            //add all info and print
            System.out.println("Company Name: " + comp.getName());
            if(cur != root)
              System.out.println("Referring Company Name: " + comp.getReferrer().getName());
            double tc;
            double ts;
            if( (new Double(comp.getCommission())).equals(Double.NaN))
              tc = 0.00;
            else
              tc = comp.getCommission();
            if( (new Double(comp.getSales())).equals(Double.NaN))
              ts = 0.00;
            else
              ts = comp.getSales();
            System.out.printf("Sales: $ %.2f", ts);
            System.out.print("\n");
            System.out.printf("Commission: $ %.2f", tc);
            System.out.print("\n");
            System.out.printf("Total Revenue: $ %.2f", (tc+ts));
            System.out.print("\n\n");
            return;
          }
          //look on left side
          else if(company.compareToIgnoreCase(cur.getCompany().getName()) < 0)
          {
            cur = cur.getLeft();
          }
          //look on right side
          else if(company.compareToIgnoreCase(cur.getCompany().getName()) > 0)
          {
            cur = cur.getRight();
          }
        }
      }
      catch( NullPointerException e)
      {
        System.out.println("This company is not in this tree.");
      }
    }
  }
  
  /********************
    * displayAllInformation - prints info about the companies in tree in ABC order
    * postcondition: prints name, referring company (if applicable), original purchase price
    * (if not NaN), sales generated, commission generated, total revenue generated 
    * (sales + commission)
    ****************/
  public void displayAllInformation() 
  {
    if (root==null)
    {
      System.out.println("No Companies");
      return;
    }
    System.out.println(String.format("%-20s%-15s%-21s%-15s%-15s%-15s", "Company", 
                                     "Purchase", "Referrer", "Sales", "Cmsn.", "Total"));
    System.out.println("-------------------------------------------"
                         +"------------------------------------------------------");
    inorderHelper(root);
  }
  
  /********************
    * inorderHelper - helps displayAllInformation occur recursively
    * parameter: comp = company node
    * postcondition: displayAllInformation occurs
    ****************/
  
  public void inorderHelper(CompanyNode comp)
  {
    if (comp != null)
    {
      inorderHelper(comp.getLeft());
      //add all info and print
      String compName = "";
      String refName = "";
      compName= comp.getCompany().getName();
      if(comp != root)
        refName = comp.getCompany().getReferrer().getName();
      double pur;
      double tc;
      double ts;
      if( (new Double(comp.getCompany().getPurchase())).equals(Double.NaN))
        pur = 0.00;
      else
        pur = comp.getCompany().getPurchase();
      if( (new Double(comp.getCompany().getCommission())).equals(Double.NaN))
        tc = 0.00;
      else
        tc = comp.getCompany().getCommission();
      if( (new Double(comp.getCompany().getSales())).equals(Double.NaN))
        ts = 0.00;
      else
        ts = comp.getCompany().getSales();
      System.out.println(String.format("%-20s%-15.2f%-21s%-15.2f%-15.2f%-15.2f",
                                       compName, pur, refName, ts, tc, (ts+tc)));
      inorderHelper(comp.getRight());
    }
  }
}