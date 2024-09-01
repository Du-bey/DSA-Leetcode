class Solution {
    public int longestCycle(int[] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            if(edges[i] != -1){
                adj.get(i).add(edges[i]);
            }
        }
        return kosaraju(n, adj);
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i =0;i<V;i++){
            revAdj.add(new ArrayList<>());
            if(!vis[i]){
                dfs1(i, vis, st, adj);
            }
        }
        
        for(int i =0;i<V;i++){
            vis[i] = false;
            for(int v : adj.get(i)){
                revAdj.get(v).add(i);
            }
        }
        int cnt = 0;
        int ans = 0;
        while(!st.isEmpty()){
            int u = st.pop();
            if(!vis[u]){
                ans = Math.max(cnt, ans);
                cnt = 1;
                cnt = dfs2(u, vis, revAdj, 0);
            }
            ans = Math.max(ans, cnt);
        }
        
        return ans == 0 ? -1 : ans + 1;
    }
    
    public void dfs1(int u, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs1(v, vis, st, adj);
            }
        }
        st.push(u);
    }
    
    public int dfs2(int u, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int c){
        vis[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v]){
                c = dfs2(v, vis, adj, c+1);
            }
        }
        return c;
    }
}