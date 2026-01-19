class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxh = 1;
        int maxv = 1;
        int loc = 1;

        for(int i = 1;i < hBars.length; i++){
            int x = hBars[i];
            if(x == hBars[i-1] + 1){
                loc++;
            }
            else{
                loc = 1;
            }
            maxh = Math.max(maxh, loc);
        }

        loc = 1;

        for(int i = 1;i < vBars.length; i++){
            int x = vBars[i];
            if(x == vBars[i-1] + 1){
                loc++;
            }
            else{
                loc = 1;
            }
            maxv = Math.max(maxv, loc);
        }

        int ans = Math.min(maxh, maxv) + 1;
        return ans * ans;
    }
}