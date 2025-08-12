class Solution {
    int w;
    public List<String> fullJustify(String[] words, int width) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        w = width;

        int i =0;
        while(i < n){
            int ltrcnt = words[i].length();
            int j = i+1;
            int slots = 0;
            
            while(j < n && ltrcnt + words[j].length() + 1 + slots <= w){
                ltrcnt += words[j].length();
                slots++;
                j++;
            }

            int remslot = w - ltrcnt;
            int spaceInSlot = (slots == 0) ? 0 : remslot / slots;
            int extraSpaces = (slots == 0) ? 0 : remslot % slots;

            if(j == n){
                spaceInSlot = 1;
                extraSpaces = 0;
            }
            ans.add(line(i, j, spaceInSlot, extraSpaces, words));
            i = j;
        }
        return ans;
    }

    public String line(int i, int j, int spaceInSlot, int extraSpaces, String[] words){

        StringBuilder sb = new StringBuilder();
        for(int k =i;k<j;k++){
            sb.append(words[k]);

            if(k == j-1) continue;

            for(int l = 0; l < spaceInSlot; l++){
                sb.append(" ");
            }
            if(extraSpaces > 0){
                sb.append(" ");
                extraSpaces--;
            }

        }
        while(sb.length() < w){
            sb.append(" ");
        }
        return sb.toString();
    }
}