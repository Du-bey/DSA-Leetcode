class Solution {
    public static int networkDelayTime(int[][] times, int n, int k) {
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int ans = 0;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.first - y.first);
        q.add(new Pair(0, k));
        dis[k] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int t = p.first;
            int u = p.second;
            if(vis[u]) continue;
            vis[u] = true;
            ans = Math.max(t, ans);
            for(Pair neig : adj.get(u)){
                int edw = neig.second;
                int v = neig.first;
                if(dis[v] > edw + t){
                    dis[v] = edw + t;
                    q.add(new Pair(dis[v], v));
                }
            }
        }
        for(int i =1;i<=n;i++){
            if(!vis[i]) {
                return -1;
            }
        }
        return ans;
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