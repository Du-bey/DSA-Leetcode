class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] freq = new int[k];
        for(int i =0;i<n;i++){
            arr[i] = ((arr[i] % k)+k) % k;
            freq[arr[i]]++;
        }
        for(int i =1;i<k-1;i++){
            if(freq[i] != freq[k-i]) return false;
        }
        if(freq[0] % 2 != 0) return false;
        return true;
    }
}