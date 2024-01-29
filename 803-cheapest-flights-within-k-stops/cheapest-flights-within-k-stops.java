class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, src, 0));

        while(!q.isEmpty()){
            int stop = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            q.remove();

            if(stop > k) continue;

            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edW = iter.second;
                if(edW+cost < dis[adjNode]){
                    dis[adjNode] = edW+cost;
                    q.add(new Triplet(stop+1, adjNode, dis[adjNode]));
                }
            }

        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
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