class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new Pair(v, w));
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, src, 0));
        while(!q.isEmpty()){
            Triplet t = q.poll();
            int stops = t.first;
            int u = t.second;
            int wt = t.third;
            if(stops > k) continue;
            for(Pair p : adj.get(u)){
                int v = p.first;
                int newWt = p.second;
                if(dis[v] > wt + newWt){
                    dis[v] = wt + newWt;
                    q.add(new Triplet(stops + 1, v, dis[v]));
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}

class Triplet {
    int first;
    int second;
    int third;
    public Triplet(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}