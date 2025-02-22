class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        int[] cnt = new int[1];
        solve(0, 2*n, ans, s, cnt);
        return ans;
    }

    public void solve(int i, int n, List<String> ans, String s, int[] cnt){
        if(cnt[0] < 0) return;
        if(i >= n){
            if(cnt[0] == 0) ans.add(s);
            return;
        }
        cnt[0]++;
        solve(i+1, n, ans, s + '(', cnt);
        cnt[0] = cnt[0] - 2;
        solve(i+1, n, ans, s + ')', cnt);
        cnt[0]++;
    }
}