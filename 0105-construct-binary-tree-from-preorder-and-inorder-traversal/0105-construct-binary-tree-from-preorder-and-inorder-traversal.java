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
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
    for(int i = 0; i < inorder.length; i++){
        inorderMap.put(inorder[i], i);
    }
    return constructTree(preorder, 0, inorder.length - 1);

    }

    public TreeNode constructTree(int[] preorder, int left, int right){
      if(left > right){
        return null;
      }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

       root.left = constructTree(preorder, left, inorderMap.get(rootValue) - 1);
       root.right = constructTree(preorder, inorderMap.get(rootValue) + 1, right);
     
       return root;
    }
}