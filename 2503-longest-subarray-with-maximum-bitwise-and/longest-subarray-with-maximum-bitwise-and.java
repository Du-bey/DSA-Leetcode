class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int x : nums){
            max = Math.max(x, max);
        }
        int ans = 0;
        int f = 0;
        int freq = 0;
        for(int i =0;i<n;i++){
            if(nums[i] == max){
                freq++;
            }
            else{
                freq = 0;
            }
            ans = Math.max(ans, freq);
        }
        return ans;
    }
}
