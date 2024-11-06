class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean bitChange;
        int high = nums[0];
        int lastGroupHigh = 0;
        
        for(int i =1;i<n;i++){
            bitChange = count_bits(nums[i]) != count_bits(high);
            if(bitChange){
                lastGroupHigh = high;
            }
            high = Math.max(high, nums[i]);
            if (nums[i] < lastGroupHigh) {
                return false;
            }
        }
        return true;
    }

    public int count_bits(int n){
        int total = 0;
        while (n > 0){
            if((n & 1) > 0) total++;
            n >>= 1;
        }
        return total;
    }
}