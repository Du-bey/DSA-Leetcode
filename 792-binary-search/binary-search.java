class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l =0;
        int h = n-1;
        while(l <= h){
            int m = (l+h) / 2;
            int mid = nums[m];
            if(mid == target) return m;
            else if(mid > target) h = m -1;
            else l = m + 1;
        }
        return -1;
    }
}