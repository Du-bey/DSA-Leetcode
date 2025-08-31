class Solution {
    public int maxDiff(int num) {
        String og = String.valueOf(num);
        int n = og.length();
        
        // --------------- MAX --------------
        char[] c = og.toCharArray();
        char ch = c[0];
        int ind = 0;
        for(int i = 0;i<n;i++){
            if(c[i] != '9'){
                ch = c[i];
                ind = i;
                break;
            }
        }

        for(int i = ind;i <n;i++){
            if(c[i] == ch){
                c[i] = '9';
            }
        }
        String max = new String(c);
        Integer maxInt = Integer.parseInt(max);

        //-----------------MIN---------------

        ind = 0;
        c = og.toCharArray();
        ch = '1';
        for(int i = 0;i<n;i++){
            if(c[i] != '1' && c[i] != '0'){
                ch = c[i];
                ind = i;
                break;
            }
        }

        char oneOrZero = (ind == 0) ? '1' : '0';

        for(int i = ind;i <n;i++){
            if(c[i] == ch){
                c[i] = oneOrZero;
                
            }
        }
        String min = new String(c);
        Integer minInt = Integer.parseInt(min);

        return maxInt - minInt;
    }
}