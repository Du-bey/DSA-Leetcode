class Solution {
    public int findJudge(int n, int[][] trust) {
        int m = trust.length;
        int[] indegree = new int[n+1];
        for(int[] t : trust){
            int u = t[0];
            int v = t[1];
            indegree[v]++;
        }
        int pos = 0;
        for(int i =1;i<=n;i++){
            if(indegree[i] == n-1){
                pos = i;
                break;
            }
        }
        for(int[] r : trust){
            if(r[0] == pos) return -1;
        }
        return pos == 0 ? -1 : pos;
    }
}