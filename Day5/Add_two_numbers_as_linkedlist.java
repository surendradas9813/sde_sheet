class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        
        int carry = 0;
        
        while(head1!=null || head2!=null){
            
            int x = head1!=null?head1.val:0;
            int y = head2!=null?head2.val:0;
            
            int sum = x+y+carry;
            
            current.next = new ListNode(sum%10);
            carry = sum / 10;
            current = current.next;
            
            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
            
        }
        
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}