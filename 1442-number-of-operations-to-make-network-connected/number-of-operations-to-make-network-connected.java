class Solution {
    int extraEdge = 0;
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r : connections){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int isolatedNetwork =0;

        for(int i =0;i<n;i++){
            if(!vis[i]){
                isolatedNetwork++;
                bfs(vis, adj, i);
            }
        }
        extraEdge /= 2;
        if(isolatedNetwork-1 > extraEdge) return -1;
        return isolatedNetwork - 1;
    }

    public void bfs(boolean[] vis, List<List<Integer>> adj, int i){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        vis[i] = true;
        while(!q.isEmpty()){
            int n = q.peek().first;
            int p = q.peek().second;
            q.remove();
            for(int it : adj.get(n)){
                if(!vis[it]){
                    q.add(new Pair(it, n));
                    vis[it] = true;
                }
                else if(vis[it] && it != p){
                    extraEdge++;
                }
            }
        }
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}