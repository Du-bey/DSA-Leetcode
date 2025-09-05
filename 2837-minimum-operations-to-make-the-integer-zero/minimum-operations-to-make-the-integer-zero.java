class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        int t = 0;
        if(num2 >= num1) return -1;
        while(true){
            long val = (long)num1 - (long)t * num2;
            if(val < 0) return -1;

            int bit = Long.bitCount(val);
            if(bit <= t && t <= val) return t;
            t++;
        }
    }
}