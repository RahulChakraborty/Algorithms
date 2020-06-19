package bst;

/**
 * Created by rahulchakraborty on 6/25/16.
 */
public class CreateBinarySearchTree {
     TreeNode root;

    public CreateBinarySearchTree(){

    }
    public CreateBinarySearchTree(int... arr){
        this();
        for(int i : arr)
            add(i);
    }

    public void add(int item) {
        if (root == null) {
            root = new TreeNode(item, null, null);
            return;
        }


        TreeNode node = root;
        while (true) {
            if (item < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(item, null, null);
                    break;
                }
                node = node.left;
            } else  if(item>node.val){

                if (node.right == null) {
                    node.right = new TreeNode(item, null, null);
                    break;
                }
                node = node.right;
            }
             else
                break;

        }
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode node) {
        if (node == null) {
            return null;
        }
        return "[" + toString(node.left) + "," + node.val + "," + toString(node.right) + "]";
    }

}
