class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] prob = new double[n+1];
        prob[0] = 1.0;

        double sum = (k == 0) ? 0 : 1;
        for(int i = 1;i<=n;i++){
            prob[i] = sum / maxPts;
            if(i < k){
                sum += prob[i];
            }

            if(i >= maxPts && (i - maxPts) < k){
                sum -= prob[i-maxPts];
            }
        }

        double ans = 0.0;
        for(int i = k;i<= n;i++){
            ans+= prob[i];
        }
        return ans;
    }
}