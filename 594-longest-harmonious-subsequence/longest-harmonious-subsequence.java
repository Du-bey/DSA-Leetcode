class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int i = 0;
        int ans = 0;
        Arrays.sort(nums);

        for(int j = 0;j<n;j++){
            while(nums[j] - nums[i] > 1){
                i++;
            }
            if(nums[j] - nums[i] == 1){
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}