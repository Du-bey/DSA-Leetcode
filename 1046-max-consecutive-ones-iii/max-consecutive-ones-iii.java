class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int kcnt = 0;
        int l =0;
        int len = 0;
        int ans = 0;
        
       for(int r = 0;r<n;r++){
            if(nums[r] == 1) len = r - l +1;
            else{
                if(kcnt < k){
                    kcnt++;
                    len  = r - l +1;
                }
                else{
                    while(kcnt >=k){
                        if(nums[l] == 0) kcnt--;
                        l++;
                        
                    }
                    r--;
                }
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
