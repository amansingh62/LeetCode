/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       List<Integer> result = new ArrayList<>();
       find(root, target);
       search(root, 0, k, result);
       return result;
    }

    private void find(TreeNode root, TreeNode target){
        if(root == null) return;

        if(root == target){
            map.put(root, 0);
            return;
        }
        find(root.left, target);
        if(map.containsKey(root.left)){
            map.put(root, map.get(root.left) + 1);
            return;
        }
        find(root.right, target);
        if(map.containsKey(root.right)){
            map.put(root, map.get(root.right) + 1);
            return;
        }
        return;
    }

    public void search(TreeNode root, int distance, int k, List<Integer> result){
        if(root == null) return;

        if(map.containsKey(root)){
            distance = map.get(root);
        }

        if(distance == k){
            result.add(root.val);
        }

        search(root.left, distance + 1, k, result);
        search(root.right, distance + 1, k, result);
    }
}