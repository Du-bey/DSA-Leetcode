class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int a = newInterval[0];
        int b = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        int i =0;
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        while(i < n){
            ans.add(intervals[i]);
            i++;
        }

    
        return ans.toArray(new int[ans.size()][]);
    }
}