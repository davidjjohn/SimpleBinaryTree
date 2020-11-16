// Simple BinaryNode using a generic that
// extends Comparable (.compareTo())

public class BinaryNode<E extends Comparable> {

    // each node contains three objects
    private E  Data;
    private BinaryNode<E> leftchild;
    private BinaryNode<E> rightchild;


    // alternate constructor that creates
    // a new leaf in the binary tree
    public BinaryNode(E item){
        Data = item;
        leftchild = null;
        rightchild = null;
    }

    // getters
    public E getData(){
        return Data;
    }
    public BinaryNode<E> getLeft(){
        return leftchild;
    }
    public BinaryNode<E> getRight(){
        return rightchild;
    }


    //  recursively insert item as a new leaf
    public void insert(E item){
        int compareV = item.compareTo(Data);
        if (compareV ==0) {
            // already in tree, I will ignore
            return;
        } else if (compareV < 0){
            if (leftchild == null){
                leftchild = new BinaryNode<E>(item);
            } else {
                leftchild.insert(item);
            }
        } else {
            if (rightchild == null){
                rightchild = new BinaryNode<E>(item);
                return;
            }
            else {
                rightchild.insert(item);
            }
        }
    }

    // boolean to determine if Left/Right child is empty
    public boolean isLeftChildEmpty(){
        return leftchild == null;
    }
    public boolean isRightChildEmpty(){
        return rightchild == null;
    }



    // recursive inorder traversal of the nodes
    public String inorder(){
        String Result = " ";

        // if there is a nonempty left child go there first
        if (!isLeftChildEmpty()){
            Result = Result + leftchild.inorder();
        }

        // now print value at the node
        Result = Result + " " + Data;

        // if there is a nonempty right child go there last
        if (!isRightChildEmpty()){
            Result = Result + " " + rightchild.inorder();
        }

        return Result;
    }


}
