class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int[] tails = new int[envelopes.length];
        int size = 0;
        for(int[] envelope : envelopes){
            int h = envelope[1];
            int left = 0, right = size;
            while(left < right){
                int mid = left +(right - left) / 2;
                if(tails[mid] < h){
                    left = mid + 1;
                } else{
                    right = mid;
                }
            }
            tails[left] = h;
            if(left == size){
                size++;
            }
        }
        return size;
    }
}