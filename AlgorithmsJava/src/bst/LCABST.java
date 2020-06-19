package bst;

/**
 * Created by rahulchakraborty on 7/31/16.
 */
public class LCABST {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode m = root;

        if(m.val > p.val && m.val < q.val){
            return m;
        }else if(m.val>p.val && m.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(m.val<p.val && m.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static boolean validBST(TreeNode root,int min,int max){

        TreeNode p =root;
        if(p==null)
            return false;

            if(p.val <= min || p.val >=max)
                return  false;

        return validBST(p.left,min,p.val)&& validBST(p.right,p.val,max);


    }

    public static int countNoOfNodes(TreeNode root){

        if(root==null)
            return 0;
        else {
              System.out.println(" Node "+root.val);
              int nodes = 1 + countNoOfNodes(root.left) + countNoOfNodes(root.right);
            return nodes;
        }
    }

    public static void main(String [] args){

        CreateBinarySearchTree cb= new CreateBinarySearchTree(2,1,3,0,6,5);
        System.out.println(" binary tree "+ cb);

        TreeNode node = lowestCommonAncestor(cb.root, new TreeNode(0), new TreeNode(5));

        validBST(cb.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println(countNoOfNodes(cb.root));



    }
}
