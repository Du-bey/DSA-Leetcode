class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long sum = nums[0] + nums[1];
        long ans = -1;
        
        for(int i =2;i<n;i++){
            if(sum > nums[i]){
                ans = Math.max(ans, sum + nums[i]);
            }
            sum += nums[i];
        }
        return ans;
    }
}