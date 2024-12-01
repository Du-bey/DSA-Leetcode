class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> h = new HashSet<>();
        for(int x : arr){
            if(h.contains(2*x) || (x % 2 ==0 && h.contains(x/2))) return true;
            h.add(x);
        }
        return false;
    }
}