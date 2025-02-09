class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        return 1 + f(1, 1, n);
    }

    public int f(int c, int p, int n){
        if(c == n) return 0;
        if(c > n) return 100000;

        int v1 = 1 + f(c+p, p, n);
        int v2 = 2 + f(c+c, c, n);
        return Math.min(v1, v2);
    }
}