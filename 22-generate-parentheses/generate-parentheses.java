class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        int cnt = 0;
        solve(0, 2*n, ans, s, cnt);
        return ans;
    }

    public void solve(int i, int n, List<String> ans, String s, int cnt){
        if(cnt < 0) return;
        if(i >= n){
            if(cnt == 0) ans.add(s);
            return;
        }
        solve(i+1, n, ans, s + '(', cnt + 1);
        solve(i+1, n, ans, s + ')', cnt - 1);
    }
}