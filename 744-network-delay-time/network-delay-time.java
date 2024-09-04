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
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Pair(k, 0));
        dis[k] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.node;
            int wt = p.wt;
            for(Pair p2 : adj.get(u)){
                int v = p2.node;
                int w = p2.wt;
                if(dis[v] > w + wt){
                    dis[v] = w+wt;
                    pq.add(new Pair(v, w+wt));
                }
            }
            
        }
        int ans = -1;
        for(int i =1;i<=n;i++){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dis[i]);
        }
        return ans;
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