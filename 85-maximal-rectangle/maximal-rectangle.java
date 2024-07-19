class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefix = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                prefix[i][j] = 0;
            }
        }

        for(int j =0;j<m;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                int number = matrix[i][j] == '1' ? 1 : 0;
                sum += number;
                if(matrix[i][j] == '0'){ 
                    sum = 0;
                }
                prefix[i][j] = sum;
            }
        }

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                 System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }
        int ans = -1;
        for(int i =0;i<n;i++){
            int area = largestRectangleArea(prefix[i]);
            ans = Math.max(ans, area);
        }
        return ans;
    }

    public static int largestRectangleArea(int[] h) {
        int n = h.length;
        if(n == 1)
        return h[0];
        int ans = -1;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && h[i] < h[st.peek()]){
                int no = h[st.pop()];
                int next = i;
                int prev = -1;
                if(!st.isEmpty()){
                    prev = st.peek();
                }
                int w = next - prev - 1;
                int a = w * no;
                ans = Math.max(ans, a);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int no = h[st.pop()];
            int next = n;
            int prev = st.isEmpty() ? -1 : st.peek();
            int w = next - prev - 1;
            int a = w * no;
            ans = Math.max(ans, a);
        }
        return ans;
    }
}