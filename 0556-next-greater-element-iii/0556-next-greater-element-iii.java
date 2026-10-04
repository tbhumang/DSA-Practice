class Solution {
    public int nextGreaterElement(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i < 0) return -1;
        int j = a.length - 1;
        while (a[j] <= a[i]) {
            j--;
        }
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        int left = i + 1;
        int right = a.length - 1;
        while (left < right) {
            temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        long result = Long.parseLong(new String(a));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
}
