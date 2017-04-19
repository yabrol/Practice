public class BinarySearchTree 
{
  private BTNode root;
  public BinarySearchTree() {
    root = null;
  }
  
  public boolean isEmpty() {
    return (root == null);
  }
  
  // other BinarySearchTree methods
  public void insert(int item) {
    BTNode newNode;
    BTNode cursor;
    boolean done = false;
    if (root == null) {
      newNode = new BTNode(item);
      root = newNode;
    }
    else {
      cursor = root;
      while (!done) {
        if (item < cursor.getData()) {
          if (cursor.getLeft() == null) {
            newNode = new BTNode(item);
            cursor.setLeft(newNode);
            done = true;
          }
          else cursor = cursor.getLeft();
        }
        else if (item > cursor.getData()) {
          if (cursor.getRight() == null) {
            newNode = new BTNode(item);
            cursor.setRight(newNode);
            done = true;
          }
          else cursor = cursor.getRight();
        }
        else done = true; // Why?
      } // end while    
    }
    
    public boolean remove(int item) {
      BTNode cursor = root;
      BTNode parentOfCursor = null;
      
      while (cursor != null && cursor.getData() != item) {
        parentOfCursor = cursor;
        if (item < cursor.getData())
          cursor = cursor.getLeft();
        else cursor = cursor.getRight();
      }
      if (cursor == null) return false;
      else {
        if (cursor == root && cursor.getLeft() == null) {
          root = root.getRight();
          
        }
        else if (cursor != root && cursor.getLeft() == null) {
          if (cursor == parentOfCursor.getLeft())
            parentOfCursor.setLeft(cursor.getRight());
          else
            parentOfCursor.setRight(cursor.getRight());
        }
        else {
          cursor.setData(cursor.getLeft().getRightmostData());
          cursor.setLeft(cursor.getLeft().removeRightmost());
        }
        return true;
      }
    }
  }
  public boolean remove(int item)
  {
    BTNode cur = root;
    BTNode par = null;
    removeHelper(cur, par, item);
  }
  public boolean removeHelper(BTNode cur, BTNode par, int item)
  {
//if
  }
  
}