class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeSet<int[]> kmin = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        TreeSet<int[]> rem = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        long sum = 0;
        int i = 1;
        while(i < n && i - dist < 1){
            int[] cur = new int[]{nums[i], i};
            kmin.add(cur);
            sum += nums[i];

            if(kmin.size() > (k - 1)){
                int[] poll = kmin.pollLast();
                sum -= poll[0];
                rem.add(poll);
            }
            i++;
        }

        long ans = Long.MAX_VALUE;
        while(i < n){
            int[] cur = new int[]{nums[i], i};
            kmin.add(cur);
            sum += nums[i];

            if(kmin.size() > (k - 1)){
                int[] poll = kmin.pollLast();
                sum -= poll[0];
                rem.add(poll);
            }

            ans = Math.min(ans, sum);

            int ri = i - dist;
            int[] tr = new int[]{nums[ri], ri};
            if(kmin.remove(tr)){
                sum -= nums[ri];
                if(!rem.isEmpty()){
                    int[] pr = rem.pollFirst();
                    sum += pr[0];
                    kmin.add(pr);
                }
            }
            else{
                rem.remove(tr);
            }
            i++;
        }
        return nums[0] + ans;
    }
}