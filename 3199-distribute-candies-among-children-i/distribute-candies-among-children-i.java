class Solution {
    public int distributeCandies(int n, int limit) {
        return f(0, n, Math.min(n, limit));
    }

    public int f(int child, int n, int l){
        if(child == 3){
            if(n == 0) return 1;
            return 0;
        }

        int ways = 0;
        for(int assign = 0; assign <= l; assign++){
            ways += f(child + 1, n - assign, l);
        }
        return ways;
    }
}