class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ans.add(root.val);
        for (Node child : root.children) ans.addAll(preorder(child));
        return ans;
    }
}