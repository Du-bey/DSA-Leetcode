class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        Pair[] event = new Pair[n*2];
        int ind = 0;
        for(int[] r : logs){
            int x = r[0];
            int y = r[1];

            Pair p1 = new Pair(x, 1);
            Pair p2 = new Pair(y, -1);

            event[ind++] = p1;
            event[ind++] = p2;
        }

        Arrays.sort(event, (a, b) -> {
            if(a.year != b.year) return a.year - b.year;
            return a.a - b.a;
        });

        int ans = 0;
        int pop = 0;
        int ansyear = 0;
        for(int i = 0;i<2*n;i++){
            Pair p = event[i];
            pop += p.a;
            if(ans < pop){
                ans = pop;
                ansyear = p.year;
            }
        }
        return ansyear;
    }
}

class Pair{
    int year;
    int a;

    public Pair(int year, int a){
        this.year = year;
        this.a = a;
    }
}