class NumberContainers {
    HashMap<Integer, PriorityQueue<Integer>> h;
    HashMap<Integer, Integer> ind;
    public NumberContainers() {
        h = new HashMap<>();
        ind = new HashMap<>();
    }
    
    public void change(int index, int num) {
        h.putIfAbsent(num, new PriorityQueue<>());
        PriorityQueue<Integer> pq = h.get(num);
        pq.add(index);
        h.put(num, pq);
        ind.put(index, num);
    }
    
    public int find(int num) {
        if(h.containsKey(num)){
            PriorityQueue<Integer> pq = h.get(num);
            while(!pq.isEmpty()){
                int index = pq.peek();
                if(ind.get(index) == num) return index;
                pq.poll();
            }
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */