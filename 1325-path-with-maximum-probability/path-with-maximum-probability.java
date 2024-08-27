class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        int m = edges.length;
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double d = succProb[i];
            adj.get(u).add(new Pair(d, v));
            adj.get(v).add(new Pair(d, u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return  (a.p> b.p) ? -1 : 1;
        }
        );
        pq.add(new Pair(1, start));
        double[] dis = new double[n];

        dis[start] = 1;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            double p = pair.p;
            int u = pair.node;
            if(u == end) return p;
            for(Pair p1 : adj.get(u)){
                int v = p1.node;
                double newdis = p1.p;
                if(p* newdis > dis[v]){
                    dis[v] = p* newdis;
                    pq.add(new Pair(dis[v], v));
                }
            }
        }
        double ans = dis[end];
        return ans;
    }
}

class Pair{
    int node;
    double p;
    public Pair(double p, int node){
        this.node = node;
        this.p = p;
    }
}