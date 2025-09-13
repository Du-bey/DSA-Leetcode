class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        int cmax = 0;
        int vmax = 0;
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vmax = Math.max(vmax, freq[c - 'a']);
            }
            else{
                cmax = Math.max(cmax, freq[c - 'a']);
            }
        }
        return cmax + vmax;
    }
}