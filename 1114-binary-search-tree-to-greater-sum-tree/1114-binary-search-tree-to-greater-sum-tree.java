/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int totalSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root != null){
            bstToGst(root.right);
            totalSum += root.val;
            root.val = totalSum;

            bstToGst(root.left);
        }
        return root;
    }
}