class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);

        for(int i =0;i<n;i++){
            if(col[i] == -1){
                if(bfs(i, col, graph) == false) return false;
            }
        }
        return true;
    }

    public boolean bfs(int i, int[] col, int[][] graph){
        col[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : graph[u]){
                if(col[v] == -1){
                    col[v] = 1 - col[u];
                    q.add(v);
                }
                else{
                    if(col[v] == col[u]) return false;
                }
            }
        }
        return true;
        
    }
}