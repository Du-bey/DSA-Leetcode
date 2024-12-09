class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int l = 1;
        int h = n - 2;

        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] != nums[mid - 1] && (nums[mid] != nums[mid + 1])) return nums[mid];
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid - 1]){
                    h = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            else{
                if(nums[mid] == nums[mid-1]){
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