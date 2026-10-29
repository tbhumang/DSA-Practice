class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int keep = 0, swap = 1;
        for (int i = 1; i < nums1.length; i++) {
            int k = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                k = keep;
                s = swap + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                k = Math.min(k, swap);
                s = Math.min(s, keep + 1);
            }
            keep = k;
            swap = s;
        }
        return Math.min(keep, swap);
    }
}