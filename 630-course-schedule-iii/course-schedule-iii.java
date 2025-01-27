class Solution {
    public int scheduleCourse(int[][] courses) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int currentDay = 0;
        for(int[] course : courses){
            int duration = course[0];
            int lastDay = course[1];

            currentDay += duration;
            maxHeap.offer(duration);

            if(currentDay > lastDay){
                currentDay -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }
}
