class Solution {
    public int maximumSwap(int num) {
        char[] c = Integer.toString(num).toCharArray();
        int max = num;
        int n = c.length;
        for(int i =0;i<n-1;i++){
            for(int j = i + 1;j<n;j++){
                swap(i, j, c);
                int newnum = Integer.parseInt(new String(c));
                max = Math.max(max, newnum);
                swap(i, j, c);
            }
        }
        return max;
    }

    public void swap(int i, int j, char[] c){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}