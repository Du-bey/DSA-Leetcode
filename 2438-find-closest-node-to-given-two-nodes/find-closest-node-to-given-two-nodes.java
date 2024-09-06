class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        dfs(node1, ans, vis, edges, 0);
        boolean[] vis2 = new boolean[n];
        dfs(node2, ans, vis2, edges, 0);
        int res = Integer.MAX_VALUE;
        int ret = -1;
        for(int i =0;i<n;i++){
            if(ans[i] < res && vis[i] && vis2[i]){
                ret = i;
                res = ans[i];
            }

        }
        return ret;
    }

    public void dfs(int u, int[] ans, boolean[] vis, int[] edges, int dis){
        if(vis[u]) return;
        vis[u] = true;
        if(ans[u] == Integer.MAX_VALUE){
            ans[u] = dis;
        }
        else {
            ans[u] = Math.max(ans[u], dis);
        }
        int v = edges[u];
        if(v != -1){
            dfs(v, ans, vis, edges, dis + 1);
        }
    }
}