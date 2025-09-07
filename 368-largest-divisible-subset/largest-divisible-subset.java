class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i =0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
        }
        int ans = 1;
        int ind = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }
            if(ans < dp[i]){
                ans = dp[i];
                ind = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(ans-- > 0){
            res.add(nums[ind]);
            ind = hash[ind];
        }
        Collections.sort(res);
        return res;
    }
}