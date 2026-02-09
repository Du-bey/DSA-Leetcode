class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            int w = r[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] s = dj(adj, n, 0);
        int[] d = dj(adj, n, n-1);

        int en = edges.length;
        boolean[] ans = new boolean[en];
        int path = s[n-1];

        for(int i=0;i<en;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if(s[u] >= Integer.MAX_VALUE || d[v] >= Integer.MAX_VALUE){
                ans[i] = false;
                continue;
            }
            int sum = s[u] + d[v] + w;
            int sum2 = s[v] + d[u] + w;
            ans[i] = (sum == path || sum2 == path); 
        }
        return ans;
    }

    public int[] dj(List<List<Pair>> adj, int n, int src){
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.a - b.a);
        pq.add(new Pair(0, src));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int d = p.a;
            int u = p.b;

            for(Pair p2 : adj.get(u)){
                int v = p2.a;
                int edw = p2.b;
                if(dis[v] > d + edw){
                    dis[v] = d + edw;
                    pq.add(new Pair(d + edw, v));
                }
            }
        }

        return dis;
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