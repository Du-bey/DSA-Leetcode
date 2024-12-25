class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pre = new int[n][m];

        for(int j =0;j<m;j++){
            int sum = 0;
            for(int i =0;i<n;i++){
                int number = matrix[i][j] == '1' ? 1 : 0;
                sum += number;
                if(matrix[i][j] == '0'){ 
                    sum = 0;
                }
                pre[i][j] = sum;
            }
        }
        int ans = 0;
        for(int i =0;i<n;i++){
            ans = Math.max(ans, largestRectangleArea(pre[i]));
        }
        return ans;
    }

    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int ind = st.pop();
                int prev = st.isEmpty() ? -1 : st.peek();
                int area = arr[ind] * (i - prev - 1);
                ans = Math.max(ans, area);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int ind = st.pop();
            int next = n;
            int prev = st.isEmpty() ? -1 : st.peek();
            int area = arr[ind] * (n - prev - 1);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}