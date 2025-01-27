class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int) (1e9 + 7);
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : roads){
            int u = t[0];
            int v = t[1];
            long w = (long) t[2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first , b.first));
        pq.add(new Pair(0, 0));
        long[] dis = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE / 2);
        dis[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            long w = p.first;
            int u = p.second;
            for(Pair p2 : adj.get(u)){
                long edw = p2.first;
                int v = p2.second;
                if(dis[v] > w + edw){
                    dis[v] = w + edw;
                    ways[v] = ways[u];
                    pq.add(new Pair(dis[v], v));
                }
                else if(dis[v] == w + edw){
                    ways[v] += ways[u];
                    ways[v] %= MOD;
                }
            }
        }
        
        return ways[n-1] % MOD;
    }
}

class Pair{
    long first;
    int second;

    public Pair(long first, int second){
        this.first = first;
        this.second = second;
    }
}