class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;

        for (int num : nums1) {
            min = Math.min(min, num);
        }

        // If minimum is odd, we can make all elements odd.
        // If minimum is even, all elements must already be even.
        if (min % 2 == 1) {
            return true;
        }

        // Minimum is even.
        // If every number is even -> true.
        // If any odd number exists -> false.
        for (int num : nums1) {
            if (num % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}