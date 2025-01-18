class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(isConnected[i][j] == 1) adj.get(i).add(j);
            }
        }
        int cnt = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int u, List<List<Integer>> adj, boolean[] vis){
        vis[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(v, adj, vis);
            }
        }
    }
}