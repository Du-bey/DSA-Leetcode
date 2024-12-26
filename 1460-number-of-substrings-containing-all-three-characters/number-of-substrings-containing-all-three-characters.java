class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[] lastseen = new int[3];
        Arrays.fill(lastseen, -1);
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            lastseen[c - 'a'] = i;
            int min = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
            if(min != -1){
                ans += min + 1;
            }
        }
        return ans;
    }
}