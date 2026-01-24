class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int i = 0;
        int j = n-1;

        int ans = 0;
        while(i < j){
            int sum = nums[i++] + nums[j--];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}