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

        int l = min;
        int h = max;
        int ans = -1;
        while(l <=h){
            int mid = (l+h)/2;
            if(possible(bloomDay, mid, m, k)){
                h = mid -1;
                ans = mid;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }



    public boolean possible(int[] num, int v, int m, int k){
        int cnt = 0;
        int ans = 0;
        for(int n : num){
            if(n <= v){
                cnt++;
            }
            else{
                ans += cnt/k;
                cnt = 0;
            }
        }
        ans += cnt/k;
        if(ans >=m) return true;
        return false;
    }
}