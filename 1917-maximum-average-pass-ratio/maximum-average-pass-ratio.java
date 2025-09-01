class Solution {
    public double maxAverageRatio(int[][] classes, int extra) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double sum = 0.0;

        for(int[] cl : classes){
            int pass = cl[0];
            int total = cl[1];
            double ratio = (double) pass/total;
            sum += ratio;
            double gain = (double) (pass + 1)/(total + 1) - ratio;
            pq.add(new double[]{gain, pass, total});
        }

        for(int i =0;i<extra;i++){
            double[] r = pq.poll();
            double gain = r[0];
            int pass = (int) r[1] + 1;
            int total = (int) r[2] + 1;
            sum += gain;

            double newGain = ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
            pq.add(new double[]{newGain, pass, total});
        }
        return sum / classes.length;
    }
}