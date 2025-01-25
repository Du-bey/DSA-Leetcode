class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;

        int i = n - 1;
        int ans = 0;
        int j = m - 1;
        while(i >= 0 && j >= 0){
            if(s[j] >= g[i]){
                j--;   
                ans++;
            }
            i--;
        }
        return ans;
    }
}