class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i =0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
        }
        int max = 0;
        for(int i =0;i<n;i++){
            for(int prev = 0;prev < i;prev++){
                if(nums[i] % nums[prev] == 0 && (1 + dp[prev]) > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                    if(dp[i] > dp[max]){
                        max = i;
                    }
                    
                }
            }
        }
        while(hash[max] != max){
            ans.add(nums[max]);
            max = hash[max];
        }
        ans.add(nums[max]);
        return ans;
    }
}
// [1,2,4,8]
// [0,1,2,3]