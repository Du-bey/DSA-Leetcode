class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] temp = new int[1001];

        for(int[] t : trips){
            int num = t[0], from = t[1], to = t[2]; 
            temp[from] += num;
            temp[to] -= num;
        }

        int cur = 0;
        for(int x : temp){
            cur += x;
            if(cur > capacity) return false;
        }
        return true;
    }
}