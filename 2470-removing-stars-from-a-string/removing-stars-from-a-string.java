class Solution {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int star = 0;
        for(int i =n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c != '*'){
                if(star == 0){
                    sb.insert(0, c);
                }
                else{
                    star--;
                } 
            }
            else{
                star++;
            }
        }
        return sb.toString();
    }
}