class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int ans = 0;
        for(int i =0;i<n;i+=2){
            if(s.charAt(i) != s.charAt(i+1)) ans++;
        }
        return ans;
    }
}