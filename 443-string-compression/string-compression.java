class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;
        
        int ind = 0;
        int freq = 0;
        int n = chars.length;
        int i = 0;

        while(i < n){
            char ch = chars[i];
            int j = i;
            while(j < n && chars[i] == chars[j]){
                j++;
            }
            freq = j - i;
            chars[ind++] = ch;
            if (freq == 1) {
                
            }
            else if(freq < 10){
                chars[ind++] = (char) (freq + '0');
            }
            else{
                String strFreq = String.valueOf(freq); 
                for (char chFreq : strFreq.toCharArray())
                    chars[ind++] = chFreq;
            }
            i = j;
        }
        return ind;
    }
}