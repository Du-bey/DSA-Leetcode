class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArray = new int[n];

        for (int[] r : shifts) {
            int st = r[0];
            int end = r[1];
            int dir = r[2];
            if (dir == 1) {
                shiftArray[st]++;
                if (end + 1 < n) shiftArray[end + 1]--;
            } else {
                shiftArray[st]--;
                if (end + 1 < n) shiftArray[end + 1]++;
            }
        }

        for (int i = 1; i < n; i++) {
            shiftArray[i] += shiftArray[i - 1];
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int currentShift = (shiftArray[i] % 26 + 26) % 26;
            char newChar = (char) ('a' + (s.charAt(i) - 'a' + currentShift) % 26);
            result.append(newChar);
        }

        return result.toString();
    }
}
