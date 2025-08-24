class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair[] arr = new Pair[n];
        for(int i =0;i<n;i++){
            arr[i] = new Pair(plantTime[i], growTime[i]);
        }

        Arrays.sort(arr, (a, b) -> b.b - a.b);
        int ans = 0;
        int ptime = 0;
        for(Pair p : arr){
            ans = Math.max(ans, ptime + p.a + p.b);
            ptime += p.a;
        }
        return ans;
    }
}

class Pair{
    int a;
    int b;
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}