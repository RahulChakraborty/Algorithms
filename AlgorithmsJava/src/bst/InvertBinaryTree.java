package bst;

import java.util.LinkedList;

/**
 * Created by rahulchakraborty on 6/26/16.
 */
public class InvertBinaryTree {

    public static void main(String[] args){

        TreeNode root = new TreeNode(4);
        root.left =  new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(9);


        System.out.println(toString(root));
        TreeNode node = invertTree(root);
        System.out.println(toString(node));
    }

    public static TreeNode invertTree(TreeNode root){

        TreeNode temp = root.left;
        root.left = root.right;
        root.right =temp;

        if(root.left!=null){
            invertTree(root.left);
        }
        if(root.right!=null){
            invertTree(root.right);

        }

        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if(root!=null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            if(p.left!=null)
                queue.add(p.left);
            if(p.right!=null)
                queue.add(p.right);

            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }

        return root;
    }


    public static String toString(TreeNode node) {
        if (node == null) {
            return null;
        }
        return "[" + toString(node.left) + "," + node.val + "," + toString(node.right) + "]";
    }
}
