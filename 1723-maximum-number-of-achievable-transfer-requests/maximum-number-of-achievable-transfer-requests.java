class Solution {
    int ans = 0;
    public int maximumRequests(int n, int[][] requests) {
        solve(0, requests.length, requests, 0, new int[n]);
        return ans;
    }

    public void solve(int i, int n, int[][] req, int cnt, int[] temp){
        if(i == n){
            for(int x : temp){
                if(x != 0) return;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        int u = req[i][0];
        int v = req[i][1];
        temp[u]--;
        temp[v]++;
        solve(i+1, n, req, cnt + 1, temp);
        temp[u]++;
        temp[v]--;
        solve(i+1, n, req, cnt, temp);
    }
}