class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        StringBuilder prev = new StringBuilder("0");
        for(int i =1;i<n;i++){
            StringBuilder temp = new StringBuilder();
            temp.append(prev + "1" + revAndInvert(prev));
            prev = temp;
        }
        return prev.charAt(k-1);
    }

    public String revAndInvert(StringBuilder s){
        StringBuilder rev = s.reverse();
        int n = rev.length();
        for(int i =0;i<n;i++){
            if(rev.charAt(i) == '0') rev.setCharAt(i, '1');
            else rev.setCharAt(i, '0');
        }
        return rev.toString();
    }
}