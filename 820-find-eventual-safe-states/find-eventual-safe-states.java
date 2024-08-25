class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdj = new ArrayList();
        int n = graph.length;
        int[] indegree = new int[n];
        for(int i =0;i<n;i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            for(int it: graph[i]){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);
            for(int v : revAdj.get(u)){
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