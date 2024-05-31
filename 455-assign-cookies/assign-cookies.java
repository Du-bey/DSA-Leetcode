class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j =0;
        int slen = s.length;
        if(slen == 0) return slen;
        int ans = 0;
        for(int i = 0; i < g.length;i++){
            if(g[i]<= s[j]){
                ans++;
                j++;
            }
            else{
                i--;
                j++;
            }
            if(j == slen) break;
        }
        return ans;
    }
}