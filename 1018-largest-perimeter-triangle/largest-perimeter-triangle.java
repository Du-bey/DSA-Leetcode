class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int ans = 0;
        int sum = nums[0] + nums[1];
        for(int i =2;i<n;i++){
            if(nums[i] < sum){
                ans = sum + nums[i];
            }
            sum += nums[i] - nums[i-2];
        }
        return ans;
    }
}