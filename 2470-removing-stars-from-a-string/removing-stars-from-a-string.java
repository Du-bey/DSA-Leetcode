class Solution {
    public String removeStars(String s) {
        int n = s.length();
        String ans = "";
        int star = 0;
        for(int i =n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c != '*'){
                if(star == 0){
                    ans = c + ans;
                }
                else{
                    star--;
                } 
            }
            else{
                star++;
            }
        }
        return ans;
    }
}