class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r : dislikes){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] col = new int[n+1];
        Arrays.fill(col, -1);

        for(int i =0;i<=n;i++){
            if(col[i] == -1){
                if(!dfs(i, col, adj, 0)) return false;
            }
        }
        return true;
    } 

    public boolean dfs(int u, int[] col, List<List<Integer>> adj, int c){
        col[u] = c;
        for(int v : adj.get(u)){
            if(col[v] == -1){
                if(!dfs(v, col, adj, 1-c)) return false;
            }
            else if(col[v] == col[u]) return false;
        }
        return true;
    }
}