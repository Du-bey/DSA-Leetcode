class Solution {
    public int minPatches(int[] nums, int n) {
        int s = nums.length;
        int ans = 0;
        int i = 0;
        long max = 0;
        
        while(max < n){
            if(i < s && nums[i] <= max + 1){
                max += nums[i++];
            }
            else{
                max += (max + 1);
                ans++;
            }
        }
        return ans;
    }
}