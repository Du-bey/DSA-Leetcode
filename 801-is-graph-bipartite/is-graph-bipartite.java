class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] col = new int[n];
        Arrays.fill(col, -1);

        for(int i =0;i<n;i++){
            if(col[i] == -1){
                if(!dfs(i, graph, col, 0)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int u, int[][] graph, int[] col, int c){
        col[u] = c;
        for(int v : graph[u]){
            if(col[v] == -1){
                if(!dfs(v, graph, col, 1 - c)) return false;
            }
            else if(col[v] == col[u]) return false;
        }
        return true;
    }
}