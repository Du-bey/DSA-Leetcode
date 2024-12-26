class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Pair[] meet = new Pair[n];
        for(int i = 0;i<n;i++){
            Pair p = new Pair(intervals[i][1], intervals[i][0]);
            meet[i] = p;
        }
        
        Arrays.sort(meet, (a, b) -> a.end - b.end);
        int prevEnd = -1000000;
        int ans = 0;
        for(int i =0;i<n;i++){
            Pair p = meet[i];
            int st = p.start;
            int en = p.end;
            
            if(prevEnd <= st){
                ans++;
                prevEnd = en;
            }
        }
        return n - ans;
    }
}

class Pair{
    int end;
    int start;
    
    public Pair(int end, int start){
        this.end = end;
        this.start = start;
    }
}
