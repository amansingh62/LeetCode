/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb){
        if(root == null) return;

        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper2(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper2(Queue<String> queue, int low, int high){
        if(queue.isEmpty()) return null;
        String s = queue.peek();
        int val = Integer.parseInt(s);
        if(val < low || val > high) return null;
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = helper2(queue, low, val);
        root.right = helper2(queue, val, high);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;