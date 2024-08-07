class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        int ind = 0;
        for(int i =0;i<n;i++){
            hash[i] = i;
            for(int j =0;j<i;j++){
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i] > max){
                ind = i;
                max = dp[i];
            }
        }
        ans.add(nums[ind]);
        while(hash[ind] != ind){
            ind = hash[ind];
            ans.add(nums[ind]);
        }
        return ans;
    }
}