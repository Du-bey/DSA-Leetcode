class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(0, -1, adj, hasApple);
    }

    public int dfs(int u, int par, List<List<Integer>> adj, List<Boolean> hasApple){
        int cost = 0;
        for(int v : adj.get(u)){
            if(v != par){
                int childCost = dfs(v, u, adj, hasApple);
                if(childCost > 0 || hasApple.get(v)){
                    cost += childCost + 2;
                }
            }
        }
        return cost;
    }
}