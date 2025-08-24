class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int ans = 0;
        int score = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = n - 1;
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i++];
                score++;
            }
            else if(score == 0) break;
            else{
                power += tokens[j--];
                score--;
            }
            ans = Math.max(ans, score);
        }
        return ans;
    }
}