class Solution {
    long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = roads.length;
        for(int i=0;i<roads.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        dfs(0, -1, adj, seats);
        return ans;
        
    }
    public long dfs(int node, int parent, List<List<Integer>> adj, int seats) {
        int passengers = 0;
        
        for(int child : adj.get(node)){
            if(child != parent){
                long p = dfs(child, node, adj, seats);
                passengers += p;
                ans += (long) Math.ceil((double)p/seats);
            }
        }
        return passengers + 1;
    }
}