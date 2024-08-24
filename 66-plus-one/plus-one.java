class Solution {
    public int[] plusOne(int[] d) {
        int n = d.length;
        List<Integer> ans = new ArrayList<>();
        int i = n-1;
        int car = 1;
        while(i >= 0){
            int x = d[i] + car;
            car = x / 10;
            ans.add(0, x % 10);
            i--;
        }
        if(car == 1) ans.add(0, car);
        int[] res = new int[ans.size()];
        for(int j=0;j<ans.size();j++){
            res[j] = ans.get(j);
        }
        return res;
    }
}