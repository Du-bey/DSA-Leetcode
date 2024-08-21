class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean neg = true;
        for(int x : nums){
            if(x >= 0) neg = false;
            max = Math.max(x, max);
        }
        if(neg) return max;
        for(int x : nums){
            sum += x;
            ans = Math.max(ans, sum);
            sum = Math.max(sum, 0);
        }
        return ans;
    }
}