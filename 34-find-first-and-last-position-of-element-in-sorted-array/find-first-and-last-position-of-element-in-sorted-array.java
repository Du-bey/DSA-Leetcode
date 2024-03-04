class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int n = nums.length;
        int lb = lowerBound(nums, target);
        if((lb == n) || nums[lb] != target){
            int[] temp = {-1, -1};
            return temp;
        }
        int [] ans = new int[2];
        ans[0] = lb;
        ans[1] = upperBound(nums, target) - 1;
        return ans;
    }

    public int lowerBound(int[] nums, int t){
        int n = nums.length;
        int lb = n;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] >= t){
                lb = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return lb;
    }

    public int upperBound(int[] nums, int t){
        int n = nums.length;
        int ub = n;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] > t){
                ub = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ub;
    }
}