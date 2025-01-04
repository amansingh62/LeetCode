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
    public TreeNode bstFromPreorder(int[] preorder) {
       return construct(preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder, int[] index, int low, int high){
        if(index[0] >= preorder.length) return null;
        
        int val = preorder[index[0]];
        if(val < low || val > high) return null;

        index[0]++;
        TreeNode root = new TreeNode(val);

        root.left = construct(preorder, index, low, val);
        root.right = construct(preorder, index, val, high);

        return root;
    }
}