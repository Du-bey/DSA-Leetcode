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

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int[] tSort = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
                vis[i] = true;
            }
        }
        int index = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(index, node);
            index++;
            for(int it : revAdj.get(node)){
                if(--indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}