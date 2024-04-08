class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        int[] last = new int[3];
        Arrays.fill(last, -1);
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            last[c - 'a'] = i;
            int min = 3;
            cnt += (1 + Math.min(last[0], Math.min(last[1], last[2])));
        }
        return cnt;
    }
}