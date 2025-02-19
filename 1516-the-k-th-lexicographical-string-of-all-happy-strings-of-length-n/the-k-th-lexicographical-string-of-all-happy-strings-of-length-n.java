class Solution {
    int cnt = 0;
    String res;
    public String getHappyString(int n, int k) {
        String ans = "";
        solve(0, n, k, ans);
        return res == null ? "" : res;
    }


    public void solve(int i, int n, int k, String ans){
        if(i == n){
            cnt++;
            if(cnt == k) res = ans;
            return;
        }

        for(char c = 'a'; c <= 'c'; c++){
            if(ans.isEmpty() || ans.charAt(ans.length() - 1) != c){
                solve(i+1, n, k, ans + c);
                if(res != null) return;
            }
        }
    }
}