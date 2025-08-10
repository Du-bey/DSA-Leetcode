class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int ans = 10000;
        while(l <= h){
            int m = l + (h-l)/2;
            int mid = nums[m];
            if(nums[l] <= mid){
                ans = Math.min(ans, nums[l]);
                l = m + 1;
            }
            else{
                ans = Math.min(ans, mid);
                h = m - 1;
            }
        }
        return ans;
    }
}