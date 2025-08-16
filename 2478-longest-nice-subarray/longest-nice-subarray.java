class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        
        int xor = nums[0];
        int sum = nums[0];

        int i = 0;
        int ans = 1;
        for(int j = 1;j<n;j++){
            xor ^= nums[j];
            sum += nums[j];
            while(xor != sum){
                xor ^= nums[i];
                sum -= nums[i];
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}