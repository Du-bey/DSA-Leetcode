class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diag = 0;
        int area = 0;
        for(int[] r : dimensions){
            int l = r[0];
            int w = r[1];
            int d = l*l + w*w;
            int a = l*w;
            if(diag < d){
                diag = d;
                area = a;
            }
            else if(diag == d){
                area = Math.max(area, a);
            }
        }
        return area;
    }
}