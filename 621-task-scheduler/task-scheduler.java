class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max = 0;
        int extra = 1;
        for(char c : tasks){
            freq[c - 'A']++;
            if(freq[c - 'A'] > max){
                max = freq[c - 'A'];
                extra = 1;
            }
            else if(freq[c - 'A'] == max){
                extra++;
            }
        }
        int ans = (max - 1) * (n + 1);
        ans += extra;
        return Math.max(ans, tasks.length);
    }
}