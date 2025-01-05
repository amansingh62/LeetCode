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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    private int[] postorder(TreeNode root){
        if(root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = postorder(root.left);
        int[] right = postorder(root.right);

        if(left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            int sum = root.val + left[3] + right[3];
            int min = Math.min(root.val, left[1]);
            int max = Math.max(root.val, right[2]);

            maxSum = Math.max(maxSum, sum);

            return new int[]{1, min, max, sum};
        }
        return new int[]{0, 0, 0, 0};
    }
}