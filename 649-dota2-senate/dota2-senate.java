class Solution {
    public String predictPartyVictory(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int r = 0;
        int d = 0;
        
        for(char ch : c){
            if(ch == 'R') r++;
            if(ch == 'D') d++;
        }
        int i = 0;
        while(r != 0 && d != 0){
            char ch = c[i];
            for(int ind = i+1; ind < i + n; ind++){
                ind %= n;
                if(c[ind] != '-' && c[ind] != ch){
                    if(ch == 'R') d--;
                    else r--;
                    c[ind] = '-';
                    break;
                }
            }
            i++;
            while(c[i % n] == '-'){
                i++;
                i %= n;
            }
            i %= n;
        }
        if(d == 0) return "Radiant";
        return "Dire";
    }
}