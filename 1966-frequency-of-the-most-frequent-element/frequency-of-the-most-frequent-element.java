class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int n = nums.length;
        int l = 0;
        long sum = 0;
        for(int r = 0;r<n;r++){
            sum += nums[r];
            while((long) nums[r] *(r - l + 1) > sum + k){
                sum -= nums[l++];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
