package bst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rahulchakraborty on 6/25/16.
 */
public class Traversal {

    private static ArrayList<Integer> integerArrayList;

    public static void main (String[] args){
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int[] arr = {1,2,3,4,5};
        CreateBinarySearchTree cb = new CreateBinarySearchTree(arr);
         System.out.println("Binary Tree "+cb);

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        preOrder(root);
        System.out.println("Inorder **************");
        inorder(root);

        System.out.println("**************");
        postOrder(root);
    }
    /* Parent Node is processed before it's children */

    public  static void preOrder(TreeNode node){

        if(node==null)
            return;

        System.out.println(node.val + " ");

        preOrder(node.left);

        preOrder(node.right);

    }

    public  static void inorder(TreeNode node){

        if(node==null)
            return;

        inorder(node.left);

        System.out.println(node.val + " ");

        inorder(node.right);

    }

    public  static void postOrder(TreeNode node){

        if(node==null)
            return;

        postOrder(node.left);

        postOrder(node.right);

        System.out.println(node.val + " ");


    }
}
