class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack<>();
        for(int num : a){
            if(num > 0){
                st.push(num);
            }
            else{  
                while(!st.isEmpty() && st.peek() < Math.abs(num) && st.peek() > 0){
                   st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(num)){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0){
                    st.push(num);
                }
            }
        }
        int n = st.size();
        int[] ans = new int[n];
        int i = n-1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }
        return ans;
    }
    
}