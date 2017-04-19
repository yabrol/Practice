///////////////////////////////////////////////
//     Yukti Abrol            108118904
//     CSE 214               HW 1 due 7/17/12
//////////////////////////////////////////////

/*******************************************
  * VectorADT Class
  * defines vectors as java objects
  * allows vector operations to be performed on these vector objects
  * NOTE: private vars public methods for ADT
  **********************************************/

public class VectorADT 
{
  //final variable for max elements
  private final int MAX_ELEMENTS = 60;
  //declare int array to store vector
  private int[] vector;
  //declare int to store num elements
  private int numE;
  
  /********************
    * constructor
    * par: size = size that this VectorADT will be
    * pre: 1<=size<=MAX_ELEMENTS
    * post: this VectorADT is zero vector
    * throw: size not in valid range
    ***************/
  public VectorADT (int size) throws InvalidSizeException
  {
    //check if size in valid range
    if( size < 1 || size > MAX_ELEMENTS)
      throw new InvalidSizeException("The size of this vector is invalid.");
    //initialize
    vector = new int[size];
    numE = size;
    //make zero vector
    for(int i = 0; i < size; i++)
    {
      vector[i] = 0;
    }
  }
  
  
  /*********************
    * clone - generates copy of VectorADT
    * returns copy of VectorADT
    *******************/
  public Object clone()
  {
    //make clone using constructor. numE is initialized in constructor
    VectorADT answer;
    try{
      answer = new VectorADT(numE);
      //copy over each element in vector
      for(int i=0;i<numE;i++)
      {
        answer.vector[i] = vector[i];
      }
      return answer;
    }
    catch (InvalidSizeException e)
    {
      System.out.print("This is the wrong size.");
    }
    return null;
  }
  
  /*******************
    * equals - compare this VectorADT to another object
    * par: obj = object to which this is compared to
    * return: true if equal
    ****************/
  public boolean equals(Object obj)
  {
    //check if same object type, else false
    if ( obj instanceof VectorADT)
    {
      VectorADT tester = (VectorADT)obj;
      //check if same length, else false
      if( tester.numE != numE)
        return false;
      //check if each element is same. order matters
      else
      {
        for(int i=0; i<numE; i++)
        {
          if(tester.vector[i] != vector[i])
            return false;
        }
        return true;
      }
    }
    else
      return false;
  }
  
  /*************************
    * setElement - sets element at given position
    * par: value = element value; element = element position
    * pre: obj is instantiated & element is valid (0 to numE-1)
    * post: sets value of given element to given value
    * throw: element not a valid position
    **********************/
  public void setElement(int value, int element) throws IllegalArguement
  {
    //check if element is valid position
    if( element < 0 || element > numE-1)
      throw new IllegalArguement();
    //sets value
    vector[element] = value;
  }
  
  /*******************
    * getElement - gets element at given position
    * par: element = element position
    * pre: obj is instantiated & element is valid (0 to numE-1)
    * returns: value of given element
    * throw: element not a valid position
    ****************/
  public int getElement(int element) throws IllegalArguement
  {
    //check if element is valid position
    if( element < 0 || element > numE-1)
      throw new IllegalArguement();
    //get value
    return vector[element];
  }
  
  /*******************
    * getSize - returns size of vector
    * returns: size
    ************/
  public int getSize()
  {
    return vector.length;
    //or return numE;
  }
  
  /*******************
    * add - returns the sum of two vectorADTs
    * par: v1 = 1st vectorADT; v2 = 2nd vectorADT
    * pre: v1 & v2 have been instantiated and are same suze
    * return: vectorADT containing sum
    * throw: either v1 or v2 is null; v1 & v2 are different sizes
    *******************/
  public static VectorADT add(VectorADT v1, VectorADT v2) throws IllegalArguement, InvalidSizeException
  {
    //check if null
    if( v1 == null || v2  == null)
      throw new IllegalArguement("The vectorADT is null");
    //check if different sizes
    if(v1.getSize() != v2.getSize())
      throw new InvalidSizeException("The vectors are not the same size");
    //instantiate answer
    VectorADT answer = new VectorADT(v1.getSize());
    //add each element
    int value;
    for(int i = 0; i < v1.getSize(); i++)
    {
      value = v1.getElement(i) + v2.getElement(i);
      answer.setElement(value, i);
    }
    return answer;
  }
  
  /************************
    * subtract - subtract vectorADTs
    * par: v1 = 1st vectorADT; v2 = 2nd vectorADT
    * pre: v1 & v2 have been instantiated and are same suze
    * return: vectorADT containing difference
    * throw: either v1 or v2 is null; v1 & v2 are different sizes
    *******************/
  public static VectorADT subtract(VectorADT v1, VectorADT v2) throws IllegalArguement, InvalidSizeException
  {
    //check if null
    if( v1 == null || v2  == null)
      throw new IllegalArguement("The vectorADT is null");
    //check if different sizes
    if(v1.getSize() != v2.getSize())
      throw new InvalidSizeException("The vectors are not the same size");
    //instantiate answer
    VectorADT answer = new VectorADT(v1.getSize());
    //subtract each element
    int value;
    for(int i = 0; i < v1.getSize(); i++)
    {
      value = v1.getElement(i) - v2.getElement(i);
      answer.setElement(value, i);
    }
    return answer;
  }
  
  /*******************
    * multipyByScalar - returns product of vector and scalar
    * par: v = vectorADT; scalar = scalar to multiply
    * pre: v has been instantiated
    * return: vectorADT conatining product
    *****************/
  public static VectorADT multiplyByScalar(VectorADT v, int scalar)
  {
    for(int i = 0; i < v.getSize(); i++)
    {
      v.vector[i] = v.vector[i] * scalar;
    }
    return v;
  }
  
  /*****************
    * dotProduct - returns dot product of two vectors
    * par: v1 = first vectorADT; v2 = second vectorADT
    * pre: v1 & v2 are instantiated and same size
    * return: dot product
    * throw: v1 and/or v2 null; v1 & v2 are different sizes
    ****************/
  public static int dotProduct(VectorADT v1, VectorADT v2) throws IllegalArguement, InvalidSizeException
  {
    //check if null
    if( v1 == null || v2  == null)
      throw new IllegalArguement("The vectorADT is null");
    //check if different sizes
    if(v1.getSize() != v2.getSize())
      throw new InvalidSizeException("The vectors are not the same size");
    //declare and initialize to return
    int answer = 0;
    //get dot product
    for(int i = 0; i < v1.getSize(); i++)
    {
      answer = answer + (v1.vector[i] * v2.vector[i]);
    }
    return answer;
  }
  
  /*************************
    * toString - returns string representations
    * return: elements separated by strings
    *****************************/
  public String toString()
  {
    String str = "";
    for(int i = 0; i < numE; i++)
    {
      str = str + vector[i] + " ";
    }
    return str;
  }
  
  
  
}