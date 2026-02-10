class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj = buildGraph(m, edges2);
        List<List<Integer>> adj2 = buildGraph(n, edges1);

        int maxd2 = 0;
        for(int i = 0;i<m;i++){
            maxd2 = Math.max(maxd2, dfs(i, adj, -1, k-1));
        }

        int[] d1 = new int[n];

        for(int i = 0;i<n;i++){
            d1[i] = maxd2 + dfs(i, adj2, -1, k);
        }

        return d1;
    }


    public List<List<Integer>> buildGraph(int m, int[][] edges2){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<m;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r : edges2){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    public int dfs(int u, List<List<Integer>> adj, int p, int k){
        if(k == 0) return 1;
        if(k < 0) return 0;

        int ans = 1;

        for(int v : adj.get(u)){
            if(v != p){
                ans += dfs(v, adj, u, k-1);
            }
        }
        return ans;
    }
}