class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        int lbi = lb(nums, target);
        if(lbi == n || nums[lbi] != target){
            int[] temp = {-1, -1};
            return temp;
        }
        int[] ans = new int[2];
        ans[0] = lbi;
        int ubi = ub(nums, target);
        ans[1] = ubi - 1;
        return ans;
    }

    public int lb(int[] nums, int k) {
        int n = nums.length;
        int l =0;
        int h = n-1;
        int ans = n;

        while(l <= h){
            int m = (l+h) / 2;
            int mid = nums[m];
            if(mid >= k){
                h = m -1;
                ans = m;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }

    public int ub(int[] nums, int k) {
        int n = nums.length;
        int l =0;
        int h = n-1;
        int ans = n;
        while(l <= h){
            int m = (l+h) / 2;
            int mid = nums[m];
            if(mid > k){
                h = m -1;
                ans = m;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }
}