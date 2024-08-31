class Solution {
    public int hIndex(int[] cit) {
        int n = cit.length;
        int[] freq = new int[n+1];
        for(int x : cit){
            if(x > freq.length - 1){
                freq[freq.length - 1]++;
            }
            else{
                freq[x]++;
            }
        }
        int sum = 0;
        for(int i =n;i>=0;i--){
            sum += freq[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}