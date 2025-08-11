class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int ans = nums[0] + nums[n-1];
        while(i < j){
            ans = Math.max(ans, nums[i++] + nums[j--]);
        }
        return ans;
    }
}