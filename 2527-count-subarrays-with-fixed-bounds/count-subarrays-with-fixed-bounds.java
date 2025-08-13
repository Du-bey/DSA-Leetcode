class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int n = nums.length;
        int leftBound = -1;
        int min = -1;
        int max = -1;
        for(int i =0;i<n;i++){
            int num = nums[i];
            if(num > maxK || num < minK){
                leftBound = i;
            }
            if(num == maxK){
                max = i;
            }
            if(num == minK){
                min = i;
            }

            int cnt = Math.min(min, max) - leftBound;
            if(cnt > 0) ans += cnt;
        }
        return ans;
    }
}