class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k) - f(nums, k -1);
    }

    public int f(int[] nums, int k){
        if(k <0) return 0;
        int n = nums.length;
        int l = 0;
        int sum = 0;
        int ans = 0;
        for(int r = 0;r < n; r++){
            sum += (nums[r] % 2);
            while(sum > k){
                sum -= (nums[l] % 2);
                l++;
            }
            ans += (r-l+1);
        }
        return ans;
    }
}