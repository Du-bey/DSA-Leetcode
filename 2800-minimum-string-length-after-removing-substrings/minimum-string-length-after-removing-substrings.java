class Solution {
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(c == 'D'){
                if(!st.isEmpty() && st.peek() == 'C'){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            else if(c == 'B'){
                if(!st.isEmpty() && st.peek() == 'A'){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            else{
                st.push(c);
            }
        }
        return st.size();
    }
}