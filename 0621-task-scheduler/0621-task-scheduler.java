
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;

        int max = 0, ties = 0;
        for (int c : count) {
            if (c > max) {
                max = c;
                ties = 1;
            } else if (c == max) {
                ties++;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + ties);
    }
}
