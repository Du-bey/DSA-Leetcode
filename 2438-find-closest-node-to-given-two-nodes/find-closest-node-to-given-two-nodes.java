class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];
        dfs(node1, dis1, vis1, edges, 0);
        dfs(node2, dis2, vis2, edges, 0);
        
        int ret = -1;
        int minDis = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            if((minDis > Math.max(dis1[i], dis2[i])) && vis1[i] && vis2[i]){
                minDis = Math.max(dis1[i], dis2[i]);
                ret = i;
            }
        }
        return ret;
    }

    public void dfs(int u, int[] ans, boolean[] vis, int[] edges, int dis){
        vis[u] = true;
        int v = edges[u];
        if(v != -1 && !vis[v]){
            ans[v] = dis + 1;
            dfs(v, ans, vis, edges, dis + 1);
        }
    }
}