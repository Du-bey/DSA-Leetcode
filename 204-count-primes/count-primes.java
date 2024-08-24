class Solution {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = 1;
        }
        for(int i =2;i<n;i++){
            if(arr[i] == 0) continue;
            int j =2;
            while(i*j < n) {
                arr[i*j] = 0;
                j++;
            }
        }
        int ans = 0;
        for(int i =2;i<n;i++){
            ans += arr[i];
        }
        return ans;
    }
}