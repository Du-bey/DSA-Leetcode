class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> h = new HashSet<>();
        for(int x : arr){
            if(h.contains(x) || h.contains(4*x)) return true;
            h.add(2*x);
        }
        return false;
    }
}