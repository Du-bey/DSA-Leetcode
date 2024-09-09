class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if(n == 1 || n == 2){
            for(int i =0;i<n;i++){
                ans.add(i);
            }
            return ans;
        }

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i =0;i<n;i++){
            if(degree[i] == 1){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            ans = new ArrayList<>();
            for(int i =0;i<size;i++){
                int u = q.poll();
                ans.add(u);
                for(int v : adj.get(u)){
                    degree[v]--;
                    if(degree[v] == 1){
                        q.add(v);
                    }
                }
            }
        }
        
        return ans;
    }
}