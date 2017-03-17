public class BTNode {
  private int data;
  private BTNode left;
  private BTNode right;
  // BTNode methods
  
  public BTNode(int initData) 
  {
    data = initData;
    left = null;
    right = null;
  }
  
  public int getData()
  {return data;}
  
  public void setData(int newData)
  {data = newData;}
  
  public BTNode getLeft()
  {return left;}
  
  public void setLeft(BTNode newLeft)
  {left = newLeft;}
  
  public BTNode getRight()
  {return right;}
  
  public void setRight(BTNode newRight)
  {right = newRight;}
  
  public int getRightmostData() {
    if (right == null) return data;
    else return right.getRightmostData();
  }
  
  public BTNode removeRightmost() {
    if (right == null) return left;
    else {
      right = right.removeRightmost();
      return this;
    }
  }
  
}
