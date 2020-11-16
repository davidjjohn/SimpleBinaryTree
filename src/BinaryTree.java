//  Simple BinaryTree example using a generic E that
//  extends Comparable (.compareTo())
//
//  David John
//  November 2020

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable> {

    private BinaryNode<E> root;

    // default constructor
    public BinaryTree(){
        root = null;
    }

    // insert item into binary tree
    public void insert(E item) {

        // if the tree is empty, then create a binary node
        // as the root with item in it
        if (root == null) {
            root = new BinaryNode<E>(item);
            return;
        }

        // insert item as a node using the order relation
        root.insert(item);
    }

    // print tree in inorder
    public String inorder(){
        String Result = "";
        if (root == null){
            return Result;
        }

        // call recursive BinaryNode inorder()
        return root.inorder();
    }

    // print tree in a breadth first order
    public String toString(){

        Queue<BinaryNode<E>> myQueue = new LinkedList<BinaryNode<E>>();
        String Result = "";

        if (root == null) return Result;

        myQueue.add(root);
        while (!myQueue.isEmpty()){
            BinaryNode<E> current = myQueue.remove();
            Result = Result + " " + current.getData();
            if (!current.isLeftChildEmpty()){
                myQueue.add(current.getLeft());
            }
            if (!current.isRightChildEmpty()){
                myQueue.add(current.getRight());
            }
        }

        return Result;
    }
}
