class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalZero = 0;
        int prod = 1;
        for(int num : nums){
            if(num == 0) totalZero++;
            else prod = prod * num;
        }
        int n = nums.length;
        int[] ans = new int[n];
        for(int i =0;i<n;i++){
            if(totalZero >= 2) ans[i] = 0;
            else if(nums[i] == 0) ans[i] = prod;
            else if(totalZero == 1) ans[i] = 0;
            else ans[i] = prod/nums[i];
        }
        return ans;
    }
}