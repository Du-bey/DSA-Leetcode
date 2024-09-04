class Solution {
    public int findJudge(int n, int[][] trust) {
        int m = trust.length;
        int[] outdegree = new int[n+1];
        int[] indegree = new int[n+1];
        for(int[] t : trust){
            int u = t[0];
            int v = t[1];
            indegree[v]++;
            outdegree[u]++;
        }
        for(int i =1;i<=n;i++){
            if(outdegree[i] == 0 && indegree[i] == n-1) return i;
        }
        return -1;
    }
}