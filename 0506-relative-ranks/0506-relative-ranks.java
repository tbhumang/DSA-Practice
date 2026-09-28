import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer[indices[i]] = "Gold Medal";
            } else if (i == 1) {
                answer[indices[i]] = "Silver Medal";
            } else if (i == 2) {
                answer[indices[i]] = "Bronze Medal";
            } else {
                answer[indices[i]] = String.valueOf(i + 1);
            }
        }

        return answer;
    }
}
