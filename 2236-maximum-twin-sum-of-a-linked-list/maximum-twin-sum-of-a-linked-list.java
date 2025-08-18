
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        ListNode pre=null;

        while(fast!=null && fast.next!=null){
            pre=slow;
            slow= slow.next;
            fast=fast.next.next;
        }
        pre.next=null;

        ListNode first= head;
        
        ListNode second= reverse(slow);

        ListNode temp=head;
        int maxSum=0;

        while(temp!=null){
            temp=temp.next;
           
           maxSum= Math.max(maxSum, first.val +second.val);
           first=first.next;
           second=second.next;
        }
        return maxSum;
    }

    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=pre;
            pre=curr;
            curr=nextNode;
        }

        return pre;
    }
}