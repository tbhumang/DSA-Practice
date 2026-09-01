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
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] values = data.trim(). split(" ");
        int[] index = {0};

        return build(values, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode build(String[] values, int[] index, int low, int high){
        if(index[0] >= values.length){
            return null;
        }
        int val = Integer.parseInt(values[index[0]]);

        if(val < low || val > high){
            return null;
        }
        index[0]++;

        TreeNode root = new TreeNode(val);
        root.left = build(values, index, low, val - 1);
        root.right = build(values, index, val + 1, high);

        return root;
    }
}