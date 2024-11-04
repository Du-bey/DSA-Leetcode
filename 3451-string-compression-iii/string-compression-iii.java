class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        int i = 0;
        while(i < n){
            int j = i;
            int freq = 0;
            while(j < n && word.charAt(i) == word.charAt(j)){
                if(freq < 9){
                    j++;
                    freq++;
                }
                else{
                    sb.append(freq);
                    sb.append(word.charAt(i));
                    freq = 0;
                }
            } 
            sb.append(freq);
            sb.append(word.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}