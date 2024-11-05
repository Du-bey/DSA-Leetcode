class MedianFinder {
    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> upper;
    public MedianFinder() {
        lower = new PriorityQueue<>(Collections.reverseOrder());
        upper = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lower.size() == 0 || lower.peek() > num){
            lower.add(num);
        }
        else{
            upper.add(num);
        }

        if(lower.size() - upper.size() > 1){
            upper.add(lower.poll());
        }
        else if(upper.size() - lower.size() > 1){
            lower.add(upper.poll());
        }
    }
    
    public double findMedian() {
        double ans = 0.0;
        if(lower.size() == upper.size()){
            ans = ((double) (upper.peek() + lower.peek()) / 2);
        }
        else if(lower.size() > upper.size()){
            ans = lower.peek();
        }
        else ans = upper.peek();
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */