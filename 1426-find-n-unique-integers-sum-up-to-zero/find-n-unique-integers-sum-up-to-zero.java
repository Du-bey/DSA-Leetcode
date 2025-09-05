class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for(int i = 0;i<n-1;i++){
            sum += i + 1;
            ans[i] = i + 1;
        }
        ans[n-1] = -sum;
        return ans;
    }
}