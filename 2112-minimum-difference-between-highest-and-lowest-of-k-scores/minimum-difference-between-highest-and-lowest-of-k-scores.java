class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = 2000000;
        int n = nums.length;
        for(int i = 0; i < n-k + 1; i++){
            int first = nums[i];
            int second = nums[i-1+k];
            ans = Math.min(ans, second - first);
        }
        return ans;
    }
}
