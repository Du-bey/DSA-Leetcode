class Solution {
    public int minEatingSpeed(int[] piles, int t) {
        int n = piles.length;
        int l = 1;
        int h = 0;
        for(int no : piles){
            h = Math.max(h, no);
        }
        while(l<=h){
            int mid = (l+h)/2;
            int hours = countHour(piles, mid);
            if(hours > t){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return l;
    }

    public static int countHour(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
}