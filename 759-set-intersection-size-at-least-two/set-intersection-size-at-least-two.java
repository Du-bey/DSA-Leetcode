class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int ans = 0;
        int l = -1;
        int h = -1;
        int n = intervals.length;

        for(int i =0;i<n;i++){
            int f = intervals[i][0];
            int s = intervals[i][1];

            if(f <= l) continue;

            int dif = f - l;
            if(f <= h){
                l = h;
                h = s;
                ans++;
            }
            else{
                ans += 2;
                l = s - 1;
                h = s;
            }
            
        }
        return ans;
    }
}