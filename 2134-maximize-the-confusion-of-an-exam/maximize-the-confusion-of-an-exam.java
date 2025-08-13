class Solution {
    public int maxConsecutiveAnswers(String ans, int k) {
        int n = ans.length();
        int res = 0;
        int freqt = 0;
        int freqf = 0;
        int i = 0;

        for(int j =0;j<n;j++){
            char ch = ans.charAt(j);
            if(ch == 'T') freqt++;
            if(ch == 'F') freqf++;
            
            
            while(Math.min(freqt, freqf) > k){
                char c = ans.charAt(i++);
                if(c == 'T') freqt--;
                if(c == 'F') freqf--;
            }

            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}