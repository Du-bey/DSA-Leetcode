class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int n = nums.length;
        int max = -1;
        for(int i =0;i<n;i++){
            max = Math.max(max, nums[i]);
        }
        int h = max;
        int ans = h;

        while(l <= h){
            int m = (l+h)/2;
            boolean p = possible(nums, m, threshold);
            if(p){
                h = m -1;
                ans = m;
            }
            else{
                l = m+1;
            }
        }
        return h + 1;
    }

    public boolean possible(int[] num, int v, int t){
        int ans = 0;
        for(int n : num){
            ans += Math.ceil((double)n/(double)v);
        }
        if(ans <=t) return true;
        return false;
    }
}