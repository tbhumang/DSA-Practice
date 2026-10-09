class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        for (Node child : root.children) ans.addAll(postorder(child));
        ans.add(root.val);
        return ans;
    }
}