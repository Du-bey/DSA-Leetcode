class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n  = colors.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            int c = colors[i];
            int adj = 1 - c;
            if(colors[(i-1+n) % n] == adj && colors[(i+1) % n] == adj) ans++;
        }
        return ans;
    }
}