class Solution {
    public int partitionString(String s) {
        int ans = 1;
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            if(freq[c - 'a'] == 1){
                ans++;
                Arrays.fill(freq, 0);
            }
            freq[c - 'a'] = 1;
        }
        return ans;
    }
}