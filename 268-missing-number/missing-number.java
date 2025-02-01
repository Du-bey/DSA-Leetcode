class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int x : nums) sum += x;
        int asum = n*(n+1);
        asum /= 2;
        return asum - sum;
    }
}