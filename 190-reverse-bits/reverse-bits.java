public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i =1;i<=32;i++){
            if(ithbitset(i, n)){
                ans = 1 << (32 - i) | ans;
            }
        }
        return ans;
    }

    public boolean ithbitset(int i, int n){
        int x = ((1 << (i-1)) & n);
        return x != 0;
    }
}