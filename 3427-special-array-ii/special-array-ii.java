class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int qn = queries.length;
        boolean[] ans = new boolean[qn];
        int ind = 0;

        int n = nums.length;
        int[] v = new int[n];
        v[0] = 0;
        for(int i =1;i<n;i++){
            v[i] = v[i-1];
            if((nums[i] - nums[i-1]) % 2 == 0){
                v[i]++;
            }
        }
        
        for(int[] r : queries){
            int a = r[0];
            int b = r[1];
            ans[ind++] = v[a] == v[b];
        }
        return ans;
    }
}