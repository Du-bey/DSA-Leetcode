class Solution {
    public int minimumTime(int n, int[][] p, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        for(int[] r : p){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        int[] maxt = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i =1;i<=n;i++){
            if(indegree[i] == 0){
                q.add(i);
                maxt[i] = time[i - 1];
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                indegree[v]--;
                maxt[v] = Math.max(maxt[v], maxt[u] + time[v - 1]);
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        for(int i =1;i<=n;i++){
            ans = Math.max(ans, maxt[i]);
        }
        return ans;
    }
}