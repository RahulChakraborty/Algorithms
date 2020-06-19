package bst;

/**
 * Created by rahulchakraborty on 6/26/16.
 */
public class SameTree {


    public static void main(String[] args){

        TreeNode root_1 = new TreeNode(4);
        root_1.left =  new TreeNode(2);
        root_1.right = new TreeNode(7);
        root_1.left.left = new TreeNode(1);
        root_1.left.right = new TreeNode(3);
        root_1.right.left= new TreeNode(6);
        root_1.right.right= new TreeNode(9);

        TreeNode root_2 = new TreeNode(4);
        root_2.left =  new TreeNode(2);
        root_2.right = new TreeNode(7);
        root_2.left.left = new TreeNode(1);
        root_2.left.right = new TreeNode(3);
        root_2.right.left= new TreeNode(6);
        root_2.right.right= new TreeNode(0);

        System.out.println(" Are the trees same "+isSame(root_1,root_2));
    }

    public static boolean isSame(TreeNode firstTree, TreeNode secondTree){

        if(firstTree == null && secondTree == null){
            return true;
        }

        else if(firstTree==null || secondTree == null){
            return false;
        }

        if(firstTree.val == secondTree.val) {
            return isSame(firstTree.left, secondTree.left) && isSame(firstTree.right, secondTree.right);
        } else{
            return false;
        }

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode p, double min, double max){
        if(p==null)
            return true;

        if(p.val <= min || p.val >= max)
            return false;

        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
}
