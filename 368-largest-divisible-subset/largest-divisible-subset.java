class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int ind = 0;
        for(int i =0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
        }
        int max = 1;
        for(int i =1;i<n;i++){
            for(int j =0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }
            if(max < dp[i]){
                max = dp[i];
                ind = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[ind]);
        while(hash[ind] != ind){
            ind = hash[ind];
            ans.add(nums[ind]);
        }
        Collections.reverse(ans);
        return ans;
    }
}