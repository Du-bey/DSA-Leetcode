class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        if(n == 0) return n;
        int ind = n-1;
        int ans = 0;
        for(int i = m-1;i>=0;i--){
            if(g[i] <= s[ind]){
                ans++;
                ind--;
            }
            if(ind < 0) break;
        }
        return ans;
    }
}