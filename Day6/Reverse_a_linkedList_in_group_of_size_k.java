class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        //Optimal solution--> O(n) time and O(1) space
        
        // Idea is to reverse k-1 link of nodes and manipulate the pointers.
        
       if(head == null) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        int length = 0;
        
        ListNode curr = head;
        
        while(curr != null){
            length++;
            curr = curr.next;
        }
        
        ListNode prev = dummyHead;
        curr = head;
        ListNode next = curr.next;
        
        while(length>=k){
            
            for(int i=1; i<k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            
            prev = curr;
            
            curr = curr.next;
            if(curr != null) next = curr.next; // we have use curr != null to avoid null pointer exception;
            
            length = length-k;
        }
        return dummyHead.next;
    }
}