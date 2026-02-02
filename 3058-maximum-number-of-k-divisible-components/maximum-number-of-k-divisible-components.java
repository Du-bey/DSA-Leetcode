class Solution {
    int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ans = 0;

        dfs(0, -1, adj, values, k);
        return ans;
    }

    public int dfs(int i, int p, List<List<Integer>> adj, int[] values, int k){
        int sum = 0;
        for(int v : adj.get(i)){
            if(v == p) continue;
            sum += dfs(v, i, adj, values, k);
            sum %= k;
        }
        sum += values[i];
        sum %= k;
        if(sum == 0) ans++;
        return sum;
    }
}