class Solution {
    int cnt;
    public long countPairs(int n, int[][] edges) {
        if(edges.length == 0){
            long mult = 1L * n * (n-1);
            return (mult / 2);
        }
        cnt = 0;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        boolean[] vis = new boolean[n];

        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        long ans = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(i, vis, adj);
                long sum = 1L * cnt * (n - cnt);
                ans += sum;
                cnt = 0;
            }
        }

        return ans / 2;
    }

    public void dfs(int u, boolean[] vis, List<List<Integer>> adj){
        vis[u] = true;
        cnt++;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(v, vis, adj);
            }
        }
    }
}