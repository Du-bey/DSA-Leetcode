class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n];
        boolean[] visited = new boolean[n];

        dfs(0, adj, labels, visited, result);
        return result;
    }

    public int[] dfs(int u, List<List<Integer>> adj, String labels, boolean[] vis, int[] res) {
        vis[u] = true;
        int[] cnt = new int[26];
        for(int v : adj.get(u)){
            if(!vis[v]){
                int[] cfreq = dfs(v, adj, labels, vis, res);
                for (int i = 0; i < 26; i++) {
                    cnt[i] += cfreq[i];
                }
            }
        }
        char c = labels.charAt(u);
        cnt[c - 'a']++;

        res[u] = cnt[c - 'a'];
        return cnt;
    }
}