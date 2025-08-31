class Solution {
    public long minimumCost(int m, int n, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);

        int i = m-2;
        int j = n-2;
        int vcut = 0;
        int hcut = 0;
        long ans = 0;
        while(i >= 0 && j >= 0){
            if(h[i] < v[j]){
                vcut++;
                ans += v[j--] * (hcut + 1);
            }
            else{
                hcut++;
                ans += h[i--] * (vcut + 1);
            }
        }

        while(i >= 0){
            hcut++;
            ans += h[i--] * (vcut + 1);
            System.out.println(ans);
        }

        while(j >= 0){
            vcut++;
            ans += v[j--] * (hcut + 1);
        }

        return ans;
    }
}