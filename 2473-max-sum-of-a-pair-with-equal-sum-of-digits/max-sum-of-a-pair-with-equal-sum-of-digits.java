class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Pair> h = new HashMap<>();
        for(int x : nums){
            int sum = getSum(x);
            h.putIfAbsent(sum, new Pair());
            Pair p = h.get(sum);
            if(x > p.first){
                p.second = p.first;
                p.first = x;
            }
            else if(x > p.second){
                p.second = x;
            }
        }

        int ans = -1;
        for(Pair p : h.values()){ 
            if(p.second > 0){
                ans = Math.max(ans, p.first + p.second);
            }
        }
        return ans;
    }

    public int getSum(int n){
        int ans = 0;
        while(n > 0){
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}

class Pair {
    public int first;
    public int second;


    public Pair() {
        this.first = 0;
        this.second = 0;
    }

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}