class MyCalendarThree {
    TreeMap<Integer, Integer> h;
    int ans;
    public MyCalendarThree() {
        ans = 1;
        h = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        h.put(startTime, h.getOrDefault(startTime, 0) + 1);
        h.put(endTime, h.getOrDefault(endTime, 0) - 1);

        int loc = 0;
        for(int v : h.values()){
            loc += v;
            ans = Math.max(ans, loc);
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */