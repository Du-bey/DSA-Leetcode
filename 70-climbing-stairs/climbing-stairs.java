class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int prev2 = 1;
        int ans = 0;
        if(n == 0 || n ==1) return n;
        for(int i =2;i<=n; i++){
            ans = prev + prev2;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}