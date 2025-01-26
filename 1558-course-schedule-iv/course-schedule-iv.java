class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Boolean> ans = new ArrayList<>();
        boolean[][] t = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();

        if(pre.length == 0){
            for(int i =0;i<queries.length;i++){
                ans.add(false);
            }
            return ans;
        }

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int[] r : pre){
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                t[u][v] = true;
                for(int i =0;i<n;i++){
                    if(t[i][u]){
                        t[i][v] = true;
                    }
                }
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        
        for(int[] r : queries){
            int u = r[0];
            int v = r[1];
            ans.add(t[u][v]);
        }
        return ans;
    }
}