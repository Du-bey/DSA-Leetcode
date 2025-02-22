class Solution {
    int ans = 0;
    int n;
    
    public int maxUniqueSplit(String s) {
        n = s.length();
        backtrack(0, s, new HashSet<>());
        return ans;
    }

    private void backtrack(int i, String s, HashSet<String> seen) {
        if(i == n){
            ans = Math.max(ans, seen.size());
        }

        for(int j =i;j<n;j++){
            if(seen.size() + (n - j) <= ans) return;
            String sub = s.substring(i, j+1);
            if(seen.contains(sub)) continue;
            seen.add(sub);
            backtrack(j+1, s, seen);
            seen.remove(sub);
        }
    }
}
