class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                vis[i] = true;
                if(bfs(i, adj, vis)) cnt++;
            }
        }
        return cnt;
    }
    public boolean bfs(int node, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        boolean ans = true;
        q.add(node);
        int numOfNodes = 0;
        int neigSize = adj.get(node).size();
        while(!q.isEmpty()){
            int n = q.peek();
            q.remove();
            vis[n] = true;
            numOfNodes++;
            if(adj.get(n).size() != neigSize) ans = false;
            for(int it : adj.get(n)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                } 
            }
        }
        return ans && neigSize == numOfNodes-1;
    }
}










