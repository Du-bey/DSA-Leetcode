class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int n = q.length;

        int[] ans = new int[n];
        int i = 0;
        for(int[] row : q){
            int u = row[0];
            int v = row[1];
            for(int ind = u;ind<=v;ind++){
                ans[i] = ans[i] ^ arr[ind];
            }
            i++;
        }
        return ans;
    }
}