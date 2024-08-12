class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int ans = 1;
        int len = 1;
        for(int i =1;i<n;i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] -1 == nums[i-1]) len++;
            else len = 1;
            ans = Math.max(ans, len);
        }
        return ans;
    }
}