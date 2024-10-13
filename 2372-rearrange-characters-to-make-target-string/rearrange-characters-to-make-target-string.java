class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] chars = new int[26];
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            chars[c - 'a']++;
        } 
        for(char c : target.toCharArray()){
            freq[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for(char c : target.toCharArray()){
            int fre = freq[c - 'a'];
            min = Math.min(min, chars[c - 'a'] / fre);
        }
        return min;
    }
}