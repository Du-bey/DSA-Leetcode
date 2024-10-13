class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int l = nums.get(0).get(0);
        int r = nums.get(0).get(0);
        PriorityQueue<Trip> pq = new PriorityQueue<>((a, b) -> a.f - b.f);
        for(int i =0;i<k;i++){
            List<Integer> list = nums.get(i);
            int no = list.get(0);
            l = Math.min(l, no);
            r = Math.max(r, no);
            pq.add(new Trip(no, i, 0));
        }

        int[] ans = new int[]{l, r};
        while(true){
            Trip t = pq.poll();
            int n = t.f;
            int i = t.s;
            int idx = t.t;
            idx++;
            if(idx >= nums.get(i).size()) break;
            int newNum = nums.get(i).get(idx);
            pq.add(new Trip(newNum, i, idx));

            r = Math.max(r, newNum);
            l = pq.peek().f;
            if(r - l < ans[1] - ans[0]){
                ans[1] = r;
                ans[0] = l;
            }
        }
        return ans;
    }
}

class Trip{
    int f;
    int s;
    int t;

    public Trip(int f, int s, int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}