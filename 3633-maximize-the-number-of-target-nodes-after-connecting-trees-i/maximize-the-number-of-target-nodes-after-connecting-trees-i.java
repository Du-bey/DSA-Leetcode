class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<m;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r : edges2){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> adj2 = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj2.add(new ArrayList<>());
        }

        for(int[] r : edges1){
            int u = r[0];
            int v = r[1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        int maxd2 = 0;
        for(int i = 0;i<m;i++){
            maxd2 = Math.max(maxd2, bfs(i, adj, k-1, m));
        }

        int[] d1 = new int[n];

        for(int i = 0;i<n;i++){
            d1[i] = maxd2 + bfs(i, adj2, k, n) - 2;
        }

        return d1;
    }

    public int bfs(int i, List<List<Integer>> adj, int k, int m){
        Queue<Integer> q = new LinkedList<>();
        int d = 1;
        q.add(i);
        boolean[] vis = new boolean[m];
        vis[i] = true;

        while(k >= 0 && !q.isEmpty()){
            int size = q.size();
            k--; 
            for(int j =0;j<size;j++){
                int u = q.poll();
                d++;
                for(int v : adj.get(u)){
                    if(!vis[v]){
                        q.add(v);
                        vis[v] = true;
                    }
                }
            }
        }
        return d;
    }
}