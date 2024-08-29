class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        if(stones == null) return 0;
        int island = 0;
        Set<String> vis = new HashSet();
        for(int i =0;i<n;i++){
            int r = stones[i][0];
            int c = stones[i][1];
            if(!vis.contains(r+"-"+c)){
                island++;
                dfs(stones, r, c, vis);
            }
        }
        return n - island;
    }
    public void dfs(int[][] stones, int r, int c, Set<String> vis){
        vis.add(r+"-"+c);
        for(int[] stone : stones){
            if((stone[0] == r || stone[1] == c) && !vis.contains(stone[0]+"-"+stone[1])){
                dfs(stones, stone[0], stone[1], vis);
            }
        }
    }
}