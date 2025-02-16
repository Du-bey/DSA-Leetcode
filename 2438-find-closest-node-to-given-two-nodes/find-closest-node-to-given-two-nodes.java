class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];
        
        dfs(edges, node1, dis1, vis1, 0);
        dfs(edges, node2, dis2, vis2, 0);

        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            if(min > Math.max(dis1[i], dis2[i]) && vis1[i] && vis2[i]){
                ans = i;
                min = Math.max(dis1[i], dis2[i]);
            }
        }
        return ans;
    }

    public void dfs(int[] edges, int u, int[] dis, boolean[] vis, int d){
        vis[u] = true;
        int v = edges[u];
        if(v != -1 && !vis[v]){
            dis[v] = d + 1;
            dfs(edges, v, dis, vis, d + 1);
        }
    }
}