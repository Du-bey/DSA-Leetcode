class Solution {
    public List<Integer> largestDivisibleSubset(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int ind = 0;
        for(int i =0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
        }
        int max = 1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<n;i++){
            for(int j =0;j<i;j++){
                if(num[i] % num[j] == 0 && dp[i] < 1+dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i] > max){
                ind = i;
                max = dp[i];
            }
        }
        ans.add(num[ind]);
        while(hash[ind] != ind){
            ind = hash[ind];
            ans.add(num[ind]);
        }
        return ans;
    }
}