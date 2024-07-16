class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char c1 = st.pop();
                if((c1 == '(' && c != ')') || (c1 == '{' && c != '}') || (c1 == '[' && c != ']')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}