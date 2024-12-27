class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int max = values[0];
        for(int j =1;j<n;j++){
            ans = Math.max(ans, max + values[j] - j);
            max = Math.max(max, values[j] + j);
        }
        return ans;
    }
}