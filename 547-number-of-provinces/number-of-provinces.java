class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(adj, vis, i);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(List<List<Integer>> adj, boolean[] vis, int u){
        vis[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(adj, vis, v);
                vis[v] = true;
            }
        }
    }
}