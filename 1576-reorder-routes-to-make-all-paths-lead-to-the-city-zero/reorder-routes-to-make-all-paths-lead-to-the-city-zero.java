class Solution {
    int cnt = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> uadj = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
            uadj.add(new ArrayList<>());
        }
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            uadj.get(u).add(v);
            uadj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        dfs(0, adj, uadj, vis);
        return cnt;
    }

    public void dfs(int n, List<List<Integer>> adj, List<List<Integer>> uadj, boolean[] vis) {
        vis[n] = true;
        for(int it : uadj.get(n)){
            if(!vis[it]){
                dfs(it, adj, uadj, vis);
                if(adj.get(n).contains(it)){

                    adj.get(it).add(n);
                    List<Integer> list = adj.get(n);
                    list.removeIf(s -> s.equals(it));
                    
                    cnt++;

                }
            }
        }
    }
}