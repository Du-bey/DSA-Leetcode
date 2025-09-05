class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int prev2 = 1;
        int prev = 2;
        for(int i = 3;i<=n;i++){
            int cur = prev2 + prev;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}