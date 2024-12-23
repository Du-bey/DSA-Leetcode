class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int mid = (l+h) / 2;
            if(nums[mid] == target) return mid;
            if(nums[l] == target) return l;
            if(nums[h] == target) return h;
            if(nums[l] < nums[mid]){
                if(nums[l] < target && target < nums[mid]){
                    h = mid - 1;                    
                }
                else{
                    l = mid + 1;
                }
            }
            else{
                if(target < nums[h] && nums[mid] < target){
                    l = mid + 1;
                }
                else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}