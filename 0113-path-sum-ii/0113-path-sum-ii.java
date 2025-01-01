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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
       findPath(root, targetSum, new ArrayList<>(), result);
        return result;

    }

    private void findPath(TreeNode node, int targetSum, List<Integer> current, List<List<Integer>> result){
        if(node == null) return;
        current.add(node.val);

         if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(current));
        } else {
            // Recurse on the left and right subtrees
             // Recurse on the left and right subtrees
            findPath(node.left, targetSum - node.val, current, result);
            findPath(node.right, targetSum - node.val, current, result);
        }

        // Backtrack by removing the last node
        current.remove(current.size() - 1);
    }
}