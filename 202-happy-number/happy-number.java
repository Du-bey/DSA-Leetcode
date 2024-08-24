class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> h = new HashSet<>();
        while(n != 1){
            if(h.contains(n)) return false;
            h.add(n);
            int sum = 0;
            while(n > 0){
                int dig = n % 10;
                n = n / 10;
                sum += (dig * dig);
            }
            n = sum;
        }
        return true;
    }
}