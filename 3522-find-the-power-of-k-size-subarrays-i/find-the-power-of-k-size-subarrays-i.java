class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        for(int i =0;i<n-k+1;i++){
            int max = nums[i];
            for(int j = i+1;j < i+k ;j++){
                max = Math.max(max, nums[j]);
                if(nums[j] - nums[j-1] != 1){
                    max = -1;
                    break;
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}
