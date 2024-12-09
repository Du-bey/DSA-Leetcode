class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(n < 2) return true;
        for(int i =1;i<n;i++){
            if((nums[i] - nums[i-1]) % 2 == 0) return false;
        }
        return true;
    }
}