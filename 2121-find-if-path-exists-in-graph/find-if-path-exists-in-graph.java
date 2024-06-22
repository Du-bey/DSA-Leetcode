class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        boolean[] found = new boolean[1];
        found[0] = false;
        dfs(adj, vis, source, destination, found);
        return found[0];
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int s, int d, boolean[] found) {
        
        if(vis[s] || found[0]) return;
        vis[s] = true;

        for(int neighbour : adj.get(s)){
            if(neighbour == d){
                System.out.println(s + " " + neighbour);
                found[0] = true;
                break;
            }
            dfs(adj, vis, neighbour, d, found);
        }
    }
}