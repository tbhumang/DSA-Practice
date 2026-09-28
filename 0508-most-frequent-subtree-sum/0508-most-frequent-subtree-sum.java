import java.util.*;

class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = node.val + dfs(node.left) + dfs(node.right);
        int count = freq.getOrDefault(sum, 0) + 1;
        freq.put(sum, count);

        maxFreq = Math.max(maxFreq, count);

        return sum;
    }
}
