class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int n1 = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n1;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        
        int[] tSort = new int[n];

        int index =0;
        int[] indegree = new int[n];
        for(int i =0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
                vis[i] = true;
            }
        }
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            tSort[index++] = node;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        
        return index == n;
    }

}