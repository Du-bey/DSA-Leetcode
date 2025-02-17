class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> ans = new HashSet<>();
        String s = "";
        int n = tiles.length();
        boolean[] vis = new boolean[n];
        solve(tiles, ans, s, vis);
        return ans.size() - 1;
    }

    public void solve(String tiles, Set<String> ans, String temp, boolean[] vis){
        ans.add(temp);
        int n = tiles.length();
        for(int i =0;i<n;i++){
            if(vis[i]) continue;
            char c = tiles.charAt(i);
            vis[i] = true;
            solve(tiles, ans, temp + c, vis);
            vis[i] = false;
        }
    }
}