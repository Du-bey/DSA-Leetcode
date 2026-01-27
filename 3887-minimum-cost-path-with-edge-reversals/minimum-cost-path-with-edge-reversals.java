class Solution {
    public int minCost(int n, int[][] edges) {
        List<List< Pair>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            int w = r[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, 2 * w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        pq.add(new Pair(0, 0));
        dis[0] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.u;
            int w = p.w;

            if(u == n-1) return w;

            for(Pair p2 : adj.get(u)){
                int v = p2.u;
                int weight = p2.w;
                if(dis[v] > w + weight){
                    dis[v] = w + weight;
                    pq.add(new Pair(v, w + weight));
                }
            }
        }
        return -1;
    }
}

class Pair{
    int u;
    int w;

    public Pair(int u, int w){
        this.u = u;
        this.w = w;
    }
}