class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int sn = encodedText.length();
        int m = sn / rows;
        int r = 0;
        int c = 0;

        StringBuilder sb = new StringBuilder();

        for(int i =0;i<m;i++){
            
            for(int row = 0;row < rows;row++){
                int nr = r + row;
                int nc = c + row;
                int pos = nr * m + nc;
                if(pos < sn){
                    char ch = encodedText.charAt(pos);
                    sb.append(ch);
                }
            }
            c++;
        }
        return sb.toString().stripTrailing();
    }
}