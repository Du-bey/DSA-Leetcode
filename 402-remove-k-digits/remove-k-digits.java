class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        Stack<Character> st = new Stack<>();
        for(int i =0;i<n;i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && st.peek() > ch && k > 0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k-- > 0){
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        sb = sb.reverse();
        int ind = 0;
        while (ind < sb.length() && sb.charAt(ind) == '0') {
            ind++;
        }
        sb.delete(0, ind);
        String ans = sb.toString();
        return ans.equals("") ? "0" : ans; 
    }
}