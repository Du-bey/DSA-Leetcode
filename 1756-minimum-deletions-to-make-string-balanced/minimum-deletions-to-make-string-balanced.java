class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] a = new int[n];
        int[] b = new int[n];
        int sum = 0;
        for(int i = n-1;i>=0;i--){
            b[i] = sum;
            sum += (s.charAt(i) == 'a') ? 1 : 0;
        }

        int ans = n-1;
        sum = 0;
        for(int i =0;i<n;i++){
            ans = Math.min(ans, b[i] + sum);
            sum += (s.charAt(i) == 'b') ? 1 : 0;
        }
        
        return ans;
    }
}