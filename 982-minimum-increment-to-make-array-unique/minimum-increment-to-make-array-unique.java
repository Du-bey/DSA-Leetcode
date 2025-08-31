class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int last = nums[0];
        int ans = 0;
        for(int i =1;i<n;i++){
            int temp = Math.max(nums[i], last + 1);
            ans += temp - nums[i];
            nums[i] = temp;
            last = nums[i];
        }
        return ans;
    }
}