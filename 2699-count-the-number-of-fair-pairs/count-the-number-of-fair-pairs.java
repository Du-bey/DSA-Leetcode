class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        
        return sum(nums, upper+1) - sum(nums, lower);
    }

    public long sum(int[] nums, int t){
        long ans = 0;
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int s = nums[l] + nums[r];
            if(s >= t){
                r--;
            }
            else{
                ans += (r-l);
                l++;
            }
        }
        return ans;
    }
}