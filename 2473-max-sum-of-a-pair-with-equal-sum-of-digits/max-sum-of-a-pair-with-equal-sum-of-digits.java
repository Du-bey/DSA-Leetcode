class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int ans = -1;
        for(int x : nums){
            int sum = getSum(x);
            if(h.get(sum) != null){
                ans = Math.max(ans, x + h.get(sum));
                h.put(sum, Math.max(h.get(sum), x));
            }
            else{
                h.put(sum, x);
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