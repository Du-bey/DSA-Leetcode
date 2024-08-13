class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int l =0;
        int r =0;
        int n = nums.length;
        int ans = 0;
        int len = 0;
        while(r < n){
            if(nums[r] == 1){
                len = r - l + 1;
            }
            else{
                if(cnt < k){
                    cnt++;
                    len = r - l + 1;
                }
                else{
                    while(cnt >= k){
                        if(nums[l] == 0) cnt--;
                        l++;
                    }
                    r--;
                }
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}