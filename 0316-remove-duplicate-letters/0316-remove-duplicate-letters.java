class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty()
                    && stack.peekLast() > c
                    && freq[stack.peekLast() - 'a'] > 0) {
                visited[stack.removeLast() - 'a'] = false;
            }
            stack.addLast(c);
            visited[c - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.removeFirst());
        }
        return ans.toString();
    }
}