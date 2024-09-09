class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int minDays(int n) {
        if(n <= 2) return n;
        if(dp.containsKey(n)) return dp.get(n);
        int a = (n % 2) + minDays(n/2);
        int b = (n % 3) + minDays(n/3);
        dp.put(n, 1 + Math.min(a, b));
        return dp.get(n);
    }
}