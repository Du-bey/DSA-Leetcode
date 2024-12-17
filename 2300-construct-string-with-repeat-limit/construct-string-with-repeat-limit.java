class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) if (freq[i] > 0) pq.add(new int[]{i, freq[i]});
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int use = Math.min(repeatLimit, curr[1]);
            result.append(String.valueOf((char) ('a' + curr[0])).repeat(use));
            curr[1] -= use;
            if (curr[1] > 0 && !pq.isEmpty()) {
                int[] next = pq.poll();
                result.append((char) ('a' + next[0]));
                next[1]--;
                if (next[1] > 0) pq.add(next);
                pq.add(curr);
            }
        }
        return result.toString();
    }
}