class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        int n = nums.length;
        int qn = queries.length;

        for(int[] quer : queries){
            
            int l = quer[0];
            int r = quer[1];
            int k = quer[2];
            int v = quer[3];

            int ind = l;
            while(ind <= r){
                nums[ind] = (int) ((1L * nums[ind] * v) % mod);
                ind += k;
            }
        }

        int ans = 0;
        for(int x : nums){
            ans ^= x;
        }
        return ans;
    }
}