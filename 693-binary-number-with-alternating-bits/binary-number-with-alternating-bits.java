class Solution {
    public boolean hasAlternatingBits(int n) {
        int last = -1;

        while(n > 0){
            int bit = n % 2;
            if(last != -1 && bit == last){
                return false;
            }
            last = bit;
            n /= 2;
        }
        return true;
    }
}