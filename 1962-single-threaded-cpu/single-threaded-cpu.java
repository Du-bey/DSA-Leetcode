class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] arr = new int[n][3];
        for(int i =0;i<n;i++){
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int time = 0;
        int ind = 0;
        int nextInd = 0;

        int[] ans = new int[n];
        
        while(ind < n){
            while(nextInd < n && arr[nextInd][0] <= time){
                pq.add(arr[nextInd++]);

            }
            if(pq.isEmpty()){
                time = arr[nextInd][0];
                continue;
            }

            int[] a = pq.poll();
            ans[ind++] = a[2];
            time += a[1];
        }

        return ans;
    }
}