class MyCalendarTwo {

    List<int[]> events;
    List<int[]> overlap;
    public MyCalendarTwo() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        overlap = new ArrayList<>();
        for(int[] e : events){
            if(Math.max(start, e[0]) < Math.min(end, e[1])){
                if(!doubleBooking(Math.max(start, e[0]), Math.min(end, e[1])))
                    return false;
            }
        }
        events.add(new int[]{start, end});
        return true;
    }

    private boolean doubleBooking(int start, int end){
        for(int[] e : overlap){
            if(Math.max(start, e[0]) < Math.min(end, e[1])){
                return false;
            }
        }
        overlap.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */