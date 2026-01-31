class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];

        int cnt = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                cnt++;
                bfs(i, vis, adj);
            }
        }
        return cnt;
    }

    public void bfs(int u, boolean[] vis, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        
        while(!q.isEmpty()){
            int node = q.poll();
            vis[node] = true;
            for(int v : adj.get(node)){
                if(!vis[v]){
                    q.add(v);
                    vis[v] = true;
                }
            }
        }
    }
}