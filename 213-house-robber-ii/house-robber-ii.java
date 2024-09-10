class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        return Math.max(rob1(nums, 0, n-2), rob1(nums, 1, n-1));
    }

    public int rob1(int[] nums, int l, int r) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int pre = 0;
        int pre2 = 0;
        for(int i =l;i<=r;i++){
            int cur = Math.max(pre, nums[i] + pre2);
            pre2 = pre;
            pre = cur;
        }
        return pre;
    }
}