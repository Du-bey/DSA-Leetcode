class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());            
        }
        for(int i =0;i<n;i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);
            for(int v : adj.get(u)){
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}