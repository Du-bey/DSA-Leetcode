class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l = 1;
        int h = 0;
        int min = 1000000;
        for(int x : nums){
            h = Math.max(h, x);
            min = Math.min(min, x);
        }
        //if(k == 1) return min;
        int ans = -1;

        while(l <= h){
            int m = l + (h-l)/2;
            int cnt = 0;
            for(int i =0;i<n;i++){
                if(nums[i] <= m){
                    cnt++;
                    i++;
                }
            }
            if(cnt >= k){
                ans = m;
                h = m - 1;
            }
            else l = m + 1;
        }
        return ans;
    }
}