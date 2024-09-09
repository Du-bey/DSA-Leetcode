class Solution {
    public int minDays(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        return f(n, dp);
    }

    public int f(int n, Map<Integer, Integer> dp){
        if(n <= 1) return n;
        if(dp.containsKey(n)) return dp.get(n);
        int a = (n % 2) + f(n/2, dp);
        int b = (n % 3) + f(n/3, dp);
        dp.put(n, 1 + Math.min(a, b));
        return dp.get(n);
    }
}