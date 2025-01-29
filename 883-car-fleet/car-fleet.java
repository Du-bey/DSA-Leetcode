class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1) return 1;
        Stack<Double> st = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < n; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, (r1, r2) -> r1[0] - r2[0]);
        for(int i = n-1; i>=0;i--){
            double time = (double) (target - combine[i][0]) / combine[i][1];
            if(!st.isEmpty() && time <= st.peek()){
                continue;
            }
            else{
                st.push(time);
            }
        }
        return st.size();
    }
}