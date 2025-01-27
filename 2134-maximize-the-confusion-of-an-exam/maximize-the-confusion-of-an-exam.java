class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int len = answerKey.length();
        int start = 0;
        int freqt = 0;
        int freqf = 0;
        int maxWindowSize = 0;
        for(int end = 0;end < len;end++){
            char ch = answerKey.charAt(end);
            if(ch == 'T'){
                freqt++;
            }
            else{
                freqf++;
            }
            
            while(Math.min(freqt, freqf) > k){
                char cstart = answerKey.charAt(start);
                if(cstart == 'T'){
                    freqt--;
                }
                else{
                    freqf--;
                }
                start++;
            }
            int lowerFreq = Math.min(freqt, freqf);
            if(lowerFreq <= k){
                maxWindowSize = Math.max(maxWindowSize, end - start + 1);
            }
        }
        return maxWindowSize;
    }
}
