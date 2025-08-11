class Solution {
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n -1;
        int ans = 0;

        int[] pow = new int[n];
        pow[0] = 1;
        for(int ind =1;ind<n;ind++){
            pow[ind] = (pow[ind-1] * 2) % mod;
        }
        
        while(i <= j){
            if(nums[i] + nums[j] > target) j--;
            else{
                ans += pow[j-i] % mod;
                ans %= mod;
                i++;
            }
        }
        return ans;
    }
}