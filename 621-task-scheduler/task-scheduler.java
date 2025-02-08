class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max = 0;
        for(char c : tasks){
            freq[c - 'A']++;
            max = Math.max(max, freq[c - 'A']);
        }
        int ans = (max - 1) * (n + 1);
        for(int f : freq){
            if(f == max) ans++;
        }
        return Math.max(ans, tasks.length);
    }
}