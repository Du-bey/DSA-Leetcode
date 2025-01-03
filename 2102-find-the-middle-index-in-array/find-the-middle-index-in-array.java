class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for(int x : nums) sum += x;
        int n = nums.length;
        if(sum == nums[0]) return 0;
        int t = nums[0];
        for(int i = 1;i<n;i++){
            if(t == sum - t - nums[i]) return i;
            t += nums[i];
        }
        return -1;
    }
}