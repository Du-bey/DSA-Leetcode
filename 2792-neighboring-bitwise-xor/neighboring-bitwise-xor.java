class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int isFirstAndLastSame = derived[n-1];
        int last = 0;
        for(int i =0;i<n-1;i++){
            if(derived[i] == 1){
                last = 1 - last;
            }
        }
        return isFirstAndLastSame == last;
    }
}