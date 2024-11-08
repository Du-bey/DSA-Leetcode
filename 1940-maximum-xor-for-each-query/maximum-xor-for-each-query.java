class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        int n = nums.length;
        int no = (1 << maximumBit) - 1;
        int[] ans = new int[n];
        int ind = 0;
        for(int x : nums){
            xor ^= x;
        }
        for(int i =n-1;i>=0;i--){
            ans[ind++] = xor ^ no;
            xor ^= nums[i];
        }

        return ans;
    }
}