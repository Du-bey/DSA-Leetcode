class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int i =0;i<n;i++){
            for(int v : graph[i]){
                adj.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}