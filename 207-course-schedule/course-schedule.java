class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        
        for(int[] r : p){
            adj.get(r[1]).add(r[0]);
            indegree[r[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            cnt++;

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        return cnt == n;
    }
}