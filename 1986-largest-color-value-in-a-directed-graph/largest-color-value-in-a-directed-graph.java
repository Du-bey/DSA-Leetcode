class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        char[] color = colors.toCharArray();
        Queue<Integer> q = new LinkedList<>();
        int[][] t = new int[n][26];
        for(int i =0;i < n; i++){
            if(inDegree[i] == 0){
                q.add(i);
                t[i][color[i] - 'a'] = 1;
            }
        }
        int ans = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            cnt++;
            ans = Math.max(ans, t[u][color[u] - 'a']);
            for(int x : adj.get(u)){
                for(int c=0;c < 26;c++){
                    int add = (c == color[x] - 'a') ? 1 : 0;
                    t[x][c] = Math.max(t[x][c], t[u][c] + add);
                }
                if(--inDegree[x] == 0){
                    q.add(x);
                }
            }
        }
        if(cnt < n) return -1;
        return ans;
    }
}