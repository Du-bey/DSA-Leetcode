class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int curMin = nums[0];

        int ans = curMax;
        for(int i =1;i<n;i++){
            int num = nums[i];
            if(num < 0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(num, curMax*num);
            curMin = Math.min(num, curMin*num);
            ans = Math.max(curMax, ans);
        }
        return ans;
    }
}