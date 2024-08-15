class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return search(nums, 0, n-1, target);
    }

    public int search(int[] nums, int l, int r, int t) {
        while(l <= r){
            int m = (l+r)/2;
            if(nums[m] == t) return m;
            else if(nums[m] > t){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return -1;
    }
}