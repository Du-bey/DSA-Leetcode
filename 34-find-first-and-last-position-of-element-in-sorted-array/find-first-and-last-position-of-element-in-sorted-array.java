class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lbi = lb(nums, target, n);
        int[] temp = new int[2];
        if(lbi == n || nums[lbi] != target){
            temp[0] = -1;
            temp[1] = -1;
            return temp;
        }
        int ubi = ub(nums, target, n);
        temp[0] = lbi;
        temp[1] = ubi - 1;
        return temp;
    }

    public int lb(int[] nums, int target, int n){
        int l = 0;
        int h = n - 1;
        int ans = n;
        while(l <= h){
            int m = (l + h) / 2;
            int mid = nums[m];
            if(mid >= target){
                ans = m;
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }

    public int ub(int[] nums, int target, int n){
        int l = 0;
        int h = n - 1;
        int ans = n;
        while(l <= h){
            int m = (l + h) / 2;
            int mid = nums[m];
            if(mid > target){
                ans = m;
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }

}