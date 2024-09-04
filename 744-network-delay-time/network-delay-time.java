class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row : times){
            int u = row[0];
            int v = row[1];
            int w = row[2];
            adj.get(u).add(new Pair(v, w));
        }
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Pair(k, 0));
        dis[k] = 0; 
        int ans = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.node;
            int wt = p.wt;
            if(vis[u]) continue;
            vis[u] = true;
            ans = Math.max(ans, wt);
            n--;
            for(Pair p2 : adj.get(u)){
                int v = p2.node;
                int w = p2.wt;
                if(dis[v] > w + wt){
                    dis[v] = w+wt;
                    pq.add(new Pair(v, w+wt));
                }
            }
        }
        return n == 0 ? ans : -1;
    }
}

class Pair{
    int node;
    int wt;
    public Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}