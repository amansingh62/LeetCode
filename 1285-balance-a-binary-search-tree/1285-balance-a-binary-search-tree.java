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
    public TreeNode balanceBST(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       inorder(root, result);
       return construct(result, 0, result.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> result){
        if(root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    private TreeNode construct(List<Integer> sorted, int low, int high){
        if(low > high) return null;

        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(sorted.get(mid));
        node.left = construct(sorted, low, mid - 1);
        node.right = construct(sorted, mid + 1, high);
        return node;
    }
}