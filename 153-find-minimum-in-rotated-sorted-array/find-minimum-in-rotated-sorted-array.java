class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int m = (l+h)/2;
            
            if(nums[l] <= nums[m]){
                ans = Math.min(ans, nums[l]);
                l = m+1;
            }
            else{
                ans = Math.min(ans, nums[m]);
                h = m-1;
            }
        }
        return ans;
    }
}