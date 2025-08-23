class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int f = -1;
        int l = -1;
        int[] ans = new int[2];
        int find = 0;

        ListNode prev = head;
        int cnt = 1;
        head = head.next;
        int min = 1000000;
        int last = -1;
        while(head.next != null){
            int p = prev.val;
            int c = head.val;
            int n = head.next.val;
            
            if((p > c && n > c) || (p < c && n < c)){
                find++;
                
                if(f == -1){
                    f = cnt;
                    last = f;
                    l = f;
                }
                else{
                    last = l;
                    l = cnt;
                    
                    min = Math.min(Math.abs(last - l), min);
                }
            }
            prev = head;
            head = head.next;
            cnt++;
        }
        
        if(find < 2){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        ans[0] = (min == 1000000) ? -1 : min;
        ans[1] = l - f;
        return ans;
    }
}