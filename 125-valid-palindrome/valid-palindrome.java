class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] c = s.toCharArray();
        int n = c.length;
        return isPalindrome(0, c, n);
    }

    public boolean isPalindrome(int i, char[] c, int n) {
        if(i >= n/2) return true;
        if(c[i] != c[n-i-1]) return false;
        return isPalindrome(i+1, c, n);
    }
}