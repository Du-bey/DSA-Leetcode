class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, ans, path);
        return ans;
    }

    public void dfs(int node, int[][] graph, List<List<Integer>> ans, List<Integer> path) {
        int n = graph.length;
        if(node == n-1){
            ans.add(new ArrayList<>(path));

        }
        for(int it : graph[node]){
            path.add(it);
            dfs(it, graph, ans, path);
            path.remove(path.size()-1);
        }
    }
}