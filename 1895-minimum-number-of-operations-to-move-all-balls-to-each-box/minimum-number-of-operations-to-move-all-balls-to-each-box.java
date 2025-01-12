class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int cumValue = 0;
        int cumValueSum = 0;

        for (int i = 0; i < n; i++) {
            answer[i] = cumValueSum;

            cumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumValueSum += cumValue;
        }

        cumValue = 0;
        cumValueSum = 0;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] += cumValueSum;

            cumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumValueSum += cumValue;
        }

        return answer;
    }
}