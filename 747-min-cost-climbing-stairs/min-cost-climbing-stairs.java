class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        int a = cost[0];
        int b = cost[1];
        for(int i =2;i<n;i++){
            int cur = cost[i] + Math.min(b, a);
            a = b;
            b = cur;
        }
        return Math.min(a, b);
    }
}