class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, ans, path);
        return ans;
    }

    public void dfs(int u, int[][] graph, List<List<Integer>> ans, List<Integer> path){
        int n = graph.length;
        if(u == n-1){
            ans.add(new ArrayList<>(path));
        }
        for(int v : graph[u]){
            path.add(v);
            dfs(v, graph, ans, path);
            path.remove(path.size() - 1);
        }
    }
}