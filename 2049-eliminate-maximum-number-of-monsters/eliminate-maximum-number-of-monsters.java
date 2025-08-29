class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] timeArr = new double[n];

        for(int i =0;i<n;i++){
            timeArr[i] = (double) dist[i]/ speed[i];
        }

        Arrays.sort(timeArr);
        double time = 1.0;
        for(int i = 1;i<n;i++){
            if(time >= timeArr[i]){
                break;
            }
            time++;
        }
        return (int)time;
    }
}
