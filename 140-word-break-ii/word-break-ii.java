class Solution {
    public List<String> wordBreak(String s, List<String> word) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(word);
        String temp = "";
        solve(0, s, word, ans, set, temp);
        return ans;
    }

    public void solve(int i, String s, List<String> word, List<String> ans, Set<String> set, String temp){
        int n = s.length();
        if(i == n){
            ans.add(temp);
            return;
        }
        for(int j =i;j<n;j++){
            String ns = s.substring(i, j+1);
            if(set.contains(ns)){
                String c = temp.length() == 0 ? "" : " ";
                solve(j+1, s, word, ans, set, temp + c + ns);
            }
        }
    }
}