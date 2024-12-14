class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> min = new PriorityQueue<>((a, b) -> a.a - b.a);
        PriorityQueue<Pair> max = new PriorityQueue<>((a, b) -> b.a - a.a);
        int i =0;
        int j =0;
        long ans = 0;
        while(j < n){
            min.add(new Pair(nums[j], j));
            max.add(new Pair(nums[j], j));
            while(Math.abs(max.peek().a - min.peek().a) > 2){
                
                i++; 
                while(!max.isEmpty() && max.peek().b < i){
                    max.poll();
                }

                while(!min.isEmpty() && min.peek().b < i){
                    min.poll();
                }
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}

class Pair{
    int a;
    int b;
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}