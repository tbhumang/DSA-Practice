class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
            }

            int next = nums[(i + 1) % n];

            if (next != (nums[i] + 1) % n) {
                increasing = false;
            }

            if (next != (nums[i] - 1 + n) % n) {
                decreasing = false;
            }
        }

        int answer = Integer.MAX_VALUE;

        if (increasing) {
            answer = Math.min(
                zeroIndex,
                n - zeroIndex + 2
            );
        }

        if (decreasing) {
            answer = Math.min(answer, Math.min(
                n - zeroIndex,
                (zeroIndex + 1) % n + 1
            ));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}