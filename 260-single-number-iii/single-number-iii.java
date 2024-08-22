class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        long xor = 0;
        for(int x : nums){
            xor ^= x;
        }
        long rbit = (xor & (xor-1)) ^ xor;
        long a =0;
        long b =0;
        for(int i =0;i<n;i++){
            long cond = nums[i] & (rbit);
            if(cond >0){
                a ^= nums[i];
            }
            else{
                b ^= nums[i];
            }
        }
        ans[0] = (int)a;
        ans[1] = (int)b;

        return ans;
    }
}