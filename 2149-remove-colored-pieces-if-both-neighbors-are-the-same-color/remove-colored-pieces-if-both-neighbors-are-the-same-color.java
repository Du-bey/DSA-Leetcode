class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int ac = 0;
        int bc = 0;
        char[] ch = colors.toCharArray();
        for(int i = 2;i<n;i++){
            char c = ch[i];
            if(c == ch[i-1] && c == ch[i-2]){
                if(c == 'A') ac++;
                else bc++;
            }
        }
        return ac > bc;
    }
}