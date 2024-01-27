class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            col[i] = -1;
        }
        for(int i =0;i<n;i++){
            if(col[i] == -1){
                if(check(graph, col, i, n) == false){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int[][] graph, int[] col, int start, int n){
        col[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it : graph[node]){
                if(col[it] == -1){
                    col[it] = 1 - col[node];
                    q.add(it);
                }
                else if(col[it] == col[node]) return false;
            }
        }
        return true;
    }
}