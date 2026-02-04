class Solution {
    int ind = 0;
    int cnt;
    public long countPairs(int n, int[][] edges) {
        if(edges.length == 0){
            long mult = 1L * n * (n-1);
            return (mult / 2);
        }
        cnt = 0;

        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer, Integer> h = new HashMap<>();

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

        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(i, vis, adj);
                h.put(ind, cnt);
                cnt = 0;
                ind++;
            }
        }

        long ans = 0;
        long sum = 0;
        for(int k : h.keySet()){
            int v1 = h.get(k);
            sum += v1;
        }

        for(int v : h.values()){
            long rem = sum - v;
            ans += 1L * rem * v;
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