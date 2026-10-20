class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length; 
        int[] temp = nums.clone(); 
        Arrays.sort(temp); 
        int []dip = new int[n + 1]; 
        int []pos = new int[n + 1]; 
        for(int i = 1; i < n; i++) {
            dip[i] = dip[i-1];
            pos[i] = pos[i-1];  
            if(nums[i] < nums[i-1]) {
                dip[i] += 1;  
                pos[i] = i; 
            }
        }
        List<Integer> div = new ArrayList<>(); 
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                div.add(i); 
                if(n / i != i) {
                    div.add(n / i); 
                }
            }
        }
        int ans = 0;
        
        for(Integer d: div) {
            boolean flag = true; 
            for(int i = 0; i < n; i+=d) {
                int l = i, r = i + d - 1; 
                int c = dip[r] - dip[l]; 
                if(c >= 2) {
                    flag = false; 
                    break; 
                }
                else if (c == 0) {
                    if (nums[l] != temp[l] || nums[r] != temp[r]) flag = false;
                } else {
                    if (nums[r] > nums[l]) { flag = false; break; }
                    int p = pos[r]; 
                    if (nums[p] != temp[l] || nums[p - 1] != temp[r]) flag = false;
                }
            }
            if(flag) {
                ans += d; 
            }
                
        }
        return ans; 
    }
}
