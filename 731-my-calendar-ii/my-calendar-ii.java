class MyCalendarTwo {

    TreeMap<Integer, Integer> event;
    public MyCalendarTwo() {
        event = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        event.put(startTime, event.getOrDefault(startTime, 0) + 1);
        event.put(endTime, event.getOrDefault(endTime, 0) - 1);

        int max = 0;
        int overlap = 0;

        for(int ev : event.keySet()){
            int del = event.get(ev);

            overlap += del;
            max = Math.max(max, overlap);
            if(max > 2){
                event.put(startTime, event.getOrDefault(startTime, 0) - 1);
                if(event.get(startTime) == 0) event.remove(startTime);

                event.put(endTime, event.getOrDefault(endTime, 0) + 1);
                if(event.get(endTime) == 0) event.remove(endTime);
                
                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */