class Solution {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(var edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        depthFirstSearch(0, -1, vis, tin, low, ans, adj);
        return ans;
    }

    private void depthFirstSearch(int node, int parent, boolean[] vis, int[] tin, int[] low, List<List<Integer>> ans, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == false){
                depthFirstSearch(it, node, vis, tin, low, ans, adj);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] > tin[node]){
                    ans.add(Arrays.asList(node, it));
                }
            }
            else {
                low[node] = Math.min(low[node], low[it]);
            }
            
        }
    }
}