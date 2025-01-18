class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        if(n <= 2) return n;

        for(int i =0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1;j<n;j++){
                int cnt = 2;
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dy = (y2 - y1);
                int dx = (x2 - x1);
                
                for(int k = 0;k<n;k++){
                    if(k != i && k != j){
                        int x3 = points[k][0];
                        int y3 = points[k][1];
                        int ndy = (y3 - y1);
                        int ndx = (x3 - x1);
                
                        if(dy * ndx == ndy * dx) cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}