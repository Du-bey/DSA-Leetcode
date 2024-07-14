class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);
        for(int i =0;i<n;i++){
            if(col[i] == -1){
                if(check(graph, i, col) == false) return false;
            }
        }
        return true;
    }

    public boolean check(int[][] graph, int node, int[] col){
        col[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int u = q.peek();
            q.remove();
            for(int v : graph[u]){
                if(col[v] == -1){
                    col[v] = 1 - col[u];
                    q.add(v);
                }
                else if(col[v] == col[u]){
                    return false;
                }
            }
        }
        return true;
    }
}