class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prevEnd = intervals[0][1];
        int ans = 1;
        int n = intervals.length;
        for(int i =1;i<n;i++){
            int curEnd = intervals[i][1];
            int curStart = intervals[i][0];
            if(curStart >= prevEnd){
                ans++;
                prevEnd = curEnd;
            }
        }
        return n - ans;
    }
}