class Solution {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = 1;
        }
        for(int i =2;i*i<n;i++){
            if(arr[i] == 0) continue;
            for(int j = i*i;j<n;j+= i){
                arr[j] = 0;
            }
        }
        int ans = 0;
        for(int i =2;i<n;i++){
            ans += arr[i];
        }
        return ans;
    }
}