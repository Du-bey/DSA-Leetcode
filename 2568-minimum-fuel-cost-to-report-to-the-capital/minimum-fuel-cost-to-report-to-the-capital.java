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
        int people = 1;
        
        for(int it : adj.get(node)){
            if(it == parent) continue;
            people+= dfs(it, node, adj, seats);
        }
        if(node != 0){
            ans+= Math.ceil((double) people/seats);
        }
        return people;
    }
}