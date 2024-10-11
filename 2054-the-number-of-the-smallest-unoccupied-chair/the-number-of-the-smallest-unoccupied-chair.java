class Solution {
    public int smallestChair(int[][] times, int target) {
        int n = times.length;
        int start = times[target][0];
        Arrays.sort(times, (a, b) -> a[0] - b [0]);
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        for(int i =0;i<n;i++) chairs.add(i);
        PriorityQueue<int[]> leaving = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i =0;i<n;i++){
            int a = times[i][0];
            int b = times[i][1];
            while(!leaving.isEmpty() && leaving.peek()[0] <= a){
                int[] arr = leaving.poll();
                chairs.add(arr[1]);
            }
            if(a == start) break;
            leaving.add(new int[]{b, chairs.poll()});
        }
        return chairs.peek();
    }
}