class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            char c= tokens[i].charAt(0);
            if(tokens[i].matches("-?\\d+")){
                int n1 = Integer.valueOf(tokens[i]);
                st.push(n1);
            }
            else if(c == '+'){
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 + n2);
            }
            else if(c == '-'){
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 - n2);
            }
            else if(c == '*'){
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 * n2);
            }
            else if(c == '/'){
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 / n2);
            }
        }
        return st.peek();
    }
}