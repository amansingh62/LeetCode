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

    private void inorder(TreeNode root, List<Integer> sorted){
        if(root == null) return;
        inorder(root.left, sorted);
        sorted.add(root.val);
        inorder(root.right, sorted);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);

        List<List<Integer>> result = new ArrayList<>();
        for(int query : queries){
            int min = min(sorted, query);
            int max = max(sorted, query);
            result.add(Arrays.asList(min, max));
        }
        return result;
    }

    private int min(List<Integer> sorted, int query){
        int start = 0, end = sorted.size() - 1;
        int min = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(sorted.get(mid) <= query){
                min = sorted.get(mid);
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
         return min;
    }

    private int max(List<Integer> sorted, int query){
        int start = 0, end = sorted.size() - 1;
        int max = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(sorted.get(mid) >= query){
                max = sorted.get(mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return max;
    }
}