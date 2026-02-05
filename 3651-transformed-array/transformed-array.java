class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0;i<n;i++){
            int x = nums[i];
            if(x > 0){
                int ind = (x + i) % n;
                ans[i] = nums[ind];
            }
            else if(x < 0){
                int ind = (x + i);
                while(ind < 0) ind += n;
                ans[i] = nums[ind];
            }
            else{
                ans[i] = x;
            }
        }
        return ans;
    }
}