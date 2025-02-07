class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;

        while(l <= h){
            int mid = (l+h) / 2;
            int m = nums[mid];
            if(m == target) return mid;
            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= m){
                    h = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else{
                if(m <= target && target <= nums[h]){
                    l = mid + 1;
                }
                else{
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}