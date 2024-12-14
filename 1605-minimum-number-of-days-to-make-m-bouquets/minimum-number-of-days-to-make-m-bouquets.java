class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m * k) return -1;
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            max = Math.max(bloomDay[i], max);
            min = Math.min(bloomDay[i], min);
        }

        int l = min, h = max, ans = -1;

        while(l <= h){
            int mid = (l+h)/2;
            if(isPossible(mid, bloomDay, m , k)){
                h = mid - 1;
                ans = mid;
            }
            else l = mid + 1;
        }
        return ans;
    }

    public boolean isPossible(int mid, int[] bloomDay, int m, int k){
        int b = 0;
        int fl = 0;
        for(int x : bloomDay){
            if(mid >= x) fl++;
            else{
                b += fl/k;
                fl = 0;
            }
        }
        b += fl/k;
        return (b >= m);
    }
}