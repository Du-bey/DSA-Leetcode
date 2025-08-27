class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        
        for(int i=0;i<26;i++){
            while(freq[i] > 0 && set.contains(freq[i])){
                freq[i]--;
                ans++;
            }
            set.add(freq[i]);
        }
        return ans;
    }
}