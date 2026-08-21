class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0])
        );
        int limit = Math.min(k, nums1.length);
        for(int i = 0; i < limit; i++){
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while(k > 0 && !pq.isEmpty()){
            int[] curr = pq.poll();

            int i = curr[1];
            int j = curr[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;
            if(j + 1 < nums2.length){
                pq.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }
        return result;
    }
}