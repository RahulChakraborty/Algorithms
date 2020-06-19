package bst;

import java.util.LinkedList;

/**
 * Created by rahulchakraborty on 8/14/16.
 */
public class HasPathSum {

    /**
            * Definition for binary tree
    * public class TreeNode {
        *     int val;
        *     TreeNode left;
        *     TreeNode right;
        *     TreeNode(int x) { val = x; }
        * }
    */
    public class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null) return false;

            LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
            LinkedList<Integer> values = new LinkedList<Integer>();

            nodes.add(root);
            values.add(root.val);

            while(!nodes.isEmpty()){
                TreeNode curr = nodes.poll();
                int sumValue = values.poll();

                if(curr.left == null && curr.right == null && sumValue==sum){
                    return true;
                }

                if(curr.left != null){
                    nodes.add(curr.left);
                    values.add(sumValue+curr.left.val);
                }

                if(curr.right != null){
                    nodes.add(curr.right);
                    values.add(sumValue+curr.right.val);
                }
            }

            return false;
        }
    }
}
