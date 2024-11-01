class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int d = 0;
        int ans = 0;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
                d++;
                ans = Math.max(ans, d);
            }
            else if(c == ')'){
                d--;
            }
        }
        return ans;
    }
}