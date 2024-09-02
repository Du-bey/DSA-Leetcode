class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            boolean[] vis = new boolean[n+1];
            if(dfs(u, v, adj, vis)){
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return new int[0];
    }

    public boolean dfs(int u, int v, List<List<Integer>> adj, boolean[] vis){
        if(u == v) return true;
        vis[u] = true;
        for(int it : adj.get(u)){
            if(!vis[it]){
                if(dfs(it, v, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}