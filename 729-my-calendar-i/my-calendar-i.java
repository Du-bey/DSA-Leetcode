class MyCalendar {
    TreeMap<Integer, Integer> h;
    public MyCalendar() {
        h = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer low = h.lowerKey(end);
        if(low == null || h.get(low) <= start){
            h.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */