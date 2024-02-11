class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : roads){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int max =0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int r1 = adj.get(i).size();
                int r2 = adj.get(j).size();
                if(adj.get(i).contains(j)){
                    r1--;
                }
                max = Math.max(max, r1+r2);
            }
        }
    return max;
    }
}