class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] indegree = new long[n];
        long ans = 0;
        int x =1;
        int[] imp = new int[n];
        for(int i =0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            indegree[u]++;
            indegree[v]++;
        }
        Arrays.sort(indegree);

        for(long i : indegree){
            ans+= i* (x++);
        }
        
        return ans;
    }
}
