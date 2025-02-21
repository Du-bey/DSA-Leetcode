class Solution {
    int ans = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] map = new int[26];
        for (char c : letters) map[c - 'a']++;
        solve(0, map, words, score, 0);
        return ans;
    }

    public void solve(int i, int[] map, String[] words, int[] score, int temp) {
        if (i == words.length) {
            ans = Math.max(ans, temp);
            return;
        }

        solve(i + 1, map, words, score, temp);

        String s = words[i];
        int[] tempFreq = map.clone();
        int wordScore = 0;
        boolean canInclude = true;

        for (char ch : s.toCharArray()) {
            tempFreq[ch - 'a']--;
            if (tempFreq[ch - 'a'] < 0) {
                canInclude = false;
                break;
            }
            wordScore += score[ch - 'a'];
        }

        if (canInclude) {
            solve(i + 1, tempFreq, words, score, temp + wordScore);
        }
    }
}
