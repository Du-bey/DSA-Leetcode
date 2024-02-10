class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[n];
        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            indegree[v]++;
        }
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}