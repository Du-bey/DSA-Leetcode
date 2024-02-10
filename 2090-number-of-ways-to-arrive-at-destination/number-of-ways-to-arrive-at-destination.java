class Solution {
    public int MOD = (int)(1e9 +7);
    public int countPaths(int n, int[][] roads) {
        int[] ways = new int[n];
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE/2);
        dis[0] = 0;
        ways[0] = 1;
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            list.get(roads[i][0]).add(new Pair((long) roads[i][2], roads[i][1]));
            list.get(roads[i][1]).add(new Pair((long)roads[i][2], roads[i][0]));
        }
        
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Long.compare( a.first,b.first));
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            int u = pq.peek().second;
            long d = pq.peek().first;
            pq.remove();
            for(Pair arr : list.get(u)){
                int v = arr.second;
                long edW = arr.first;
                if(dis[v] > d + edW){
                    dis[v] = d + edW;
                    pq.add(new Pair(dis[v], v));
                    ways[v] = ways[u];
                }
                else if(dis[v] == d + edW){
                    ways[v] = (ways[v] + ways[u]) % MOD;

                }
            }
        }
        return ways[n-1]% MOD;
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