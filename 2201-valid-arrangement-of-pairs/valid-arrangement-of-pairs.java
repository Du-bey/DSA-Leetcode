class Solution {

    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private List<Integer> eulerPath = new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length;

        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();

        for(int[] r : pairs){
            int u = r[0];
            int v = r[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            in.put(v, in.getOrDefault(v, 0) + 1);
            out.put(u, out.getOrDefault(u, 0) + 1);
        }

        int start = pairs[0][0];
        for(int x : out.keySet()){
            if(out.get(x) - in.getOrDefault(x, 0) == 1){
                start = x;
                break;
            }
        }
        dfs(start);
        int[][] ans = new int[n][2];
        Collections.reverse(eulerPath);
        for(int i =0;i<eulerPath.size() - 1;i++){
            ans[i][0] = eulerPath.get(i);
            ans[i][1] = eulerPath.get(i+1);
        }
        return ans;
    }

    public void dfs(int node){
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            int nextNode = adj.get(node).remove(adj.get(node).size() - 1);
            dfs(nextNode);
        }
        eulerPath.add(node); 
    }
}