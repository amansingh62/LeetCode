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
        if(root == null){
           sb.append("null,");
           return;
        }
        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return helper2(queue);
    }

    private TreeNode helper2(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = helper2(queue);
        root.right = helper2(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));