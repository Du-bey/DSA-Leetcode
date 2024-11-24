class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ind = 0;
        int l = 0;
        int cnt = 1;
        for(int r =0;r < n;r++){
            if(r > 0 && nums[r] - nums[r-1] == 1) cnt++;
            if(r - l + 1 > k){
                if(nums[l+1] - nums[l] == 1) cnt --;
                l++;
            }
            if((r - l + 1) == k){
                ans[ind++] = (cnt == k) ? nums[r] : -1;
            }
        }
        return ans;
    }
}
