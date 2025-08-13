class Solution {
    public int longestSubarray(int[] nums) {
        int cnt = 0;
        int n = nums.length;

        int i = 0;
        int ans = 0;
        for(int j =0;j<n;j++){
            if(nums[j] == 0) cnt++;
            while(cnt > 1){
                if(nums[i] == 0) cnt--;
                i++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}