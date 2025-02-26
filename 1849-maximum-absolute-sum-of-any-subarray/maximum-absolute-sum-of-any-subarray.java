class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int negSum = 0;
        int ans = 0;
        for(int x : nums){
            sum += x;
            negSum += x;
            sum = Math.max(sum, 0);
            negSum = Math.min(negSum, 0);
            ans = Math.max(ans, sum);
            ans = Math.max(ans, Math.abs(negSum));
        }
        return ans;
    }
}