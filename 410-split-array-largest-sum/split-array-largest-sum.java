class Solution {
    public int splitArray(int[] arr, int k) {
        int sum = 0;
        int n = arr.length;
        if(k > n) return -1;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            max = Math.max(arr[i], max);
            sum += arr[i];
        }
        int l = max;
        int h = sum;
        while(l <= h){
            int m = (l+h)/2;
            int noOfSt = check(arr, m, n);
            if(noOfSt > k){
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return l;
    }
    public static int check(int[] arr, int m, int n){
        int st = 1;
        int pg = 0;
        for(int i =0;i<n;i++){
            int no = arr[i];
            if(pg + no <= m){
                pg += no;
            }
            else{
                st++;
                pg = no;
            }
        }
        return st;
    }
}