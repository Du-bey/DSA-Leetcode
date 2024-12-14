class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;
        for(int x : nums){
            l = Math.max(l, x);
            h += x;
        }

        while(l <= h){
            int m = (l + h)/2;
            if(isPossible(m, nums, k)){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return l;
    }
    
    public boolean isPossible(int m, int[] nums, int k){
        int div = 0;
        int sum = 0;
        for(int x : nums){
            sum += x;
            if(sum > m){
                sum = x;
                div++;
            }
        }
        if(sum > 0) div++;
        return div <= k;
    }
}