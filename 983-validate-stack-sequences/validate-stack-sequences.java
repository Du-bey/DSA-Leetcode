class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int m = popped.length;
        Stack<Integer> st = new Stack<>();
        if(n != m) return false;
        int ind = 0;
        for(int i =0;i<n;i++){
            st.push(pushed[i]);
            while (!st.isEmpty() && st.peek() == popped[ind]){
                st.pop();
                ind++;
            }
        }
        while(!st.isEmpty()){
            int x = st.pop();
            if(x != popped[ind++]) return false;
        }
        return true;
    }
}