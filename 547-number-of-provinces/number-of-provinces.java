class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n  = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(adj, i, vis);
                cnt++;
            }
        }
        return cnt;
    }
    
    private void dfs(List<List<Integer>> adj, int i,boolean[] vis){
        vis[i] = true;
        for(int it : adj.get(i)){
            if(!vis[it]){
                dfs(adj, it, vis);
            }
        }
    }
}