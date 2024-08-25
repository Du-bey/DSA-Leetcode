class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            cnt++;
            for(int v : adj.get(u)){
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        return cnt == n;
    }
}