
class NumberContainers {
    HashMap<Integer, TreeSet<Integer>> h;
    HashMap<Integer, Integer> ind;

    public NumberContainers() {
        h = new HashMap<>();
        ind = new HashMap<>();
    }
    
    public void change(int index, int num) {
        if (ind.containsKey(index)) {
            int oldNum = ind.get(index);
            if (oldNum != num) {
                h.get(oldNum).remove(index);
                if (h.get(oldNum).isEmpty()) {
                    h.remove(oldNum);
                }
            }
        }
        h.putIfAbsent(num, new TreeSet<>());
        h.get(num).add(index);
        ind.put(index, num);
    }
    
    public int find(int num) {
        return h.containsKey(num) && !h.get(num).isEmpty() ? h.get(num).first() : -1;
    }
}
