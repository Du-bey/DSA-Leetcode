class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE) return false;
        int ans = n & (n-1);
        return ans == 0;
    }
}