class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] col = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        Arrays.fill(col, -1);
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<dislikes.length;i++){
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i =0;i<=n;i++){
            if(col[i] == -1){
                if(check(adj, col, i, n) == false){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(List<List<Integer>> adj, int[] col, int start, int n){
        col[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it : adj.get(node)){
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