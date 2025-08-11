class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int l = 1;
        int h = 1000000;

        int ans = 0;
        while(l <= h){
            int m = (l+h) /2;
            if(isPossible(m, n, q)){
                h = m - 1;
                ans = m;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int m, int n, int[] q){
        int cnt = 0;
        for(int i =0;i<q.length;i++){
            cnt += ((q[i] + m - 1) / m);
            if(cnt > n) return false;
        }
        return true;
    }
}