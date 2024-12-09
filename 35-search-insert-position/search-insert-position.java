class Solution {
    public int searchInsert(int[] nums, int k) {
        int n = nums.length;
        int l =0;
        int h = n-1;
        int ans = -1;
        while(l <= h){
            int m = (l+h) / 2;
            int mid = nums[m];
            if(mid == k) return m;
            else if(mid >= k) h = m -1;
            else{
                ans = m;
                l = m + 1;
            }
        }
        return ans + 1;
    }
}