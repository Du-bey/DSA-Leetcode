class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int d = roads[i][2];
            adj.get(u).add(new Pair(v, d));
            adj.get(v).add(new Pair(u, d));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[n+1];
        vis[0] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for(Pair p : adj.get(u)){
                int v = p.a;
                int d = p.b;
                ans = Math.min(ans, d);
                if(!vis[v]){
                    vis[v] = true;
                    q.add(v);
                }
            }
        }

        return ans;
    }
}

class Pair{
    int a;
    int b;
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}