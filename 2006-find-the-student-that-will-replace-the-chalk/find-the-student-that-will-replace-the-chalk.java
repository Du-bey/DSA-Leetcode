class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int sum =0;
        for(int c : chalk){
            sum += c;
            if(sum >= k) break;
        }
        k = k % sum;
        for(int i=0;i<n;i++){
            k -= chalk[i];
            if(k < 0) return i;
        }
        return -1;
    }
}