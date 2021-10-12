class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //Brute force --> find length of the list and subtract from n and traverse that much and manipulate the pointer
        
        
        //Optimal Approach
        // Idea is to maintain difference between slow and fast of n
        // first we traverse n steps of fast and then both so that they maintain same till fast reaches end and manipulate the address
        
        ListNode dummyHead = new ListNode(-1); // becuase we might require to delete the first node
            
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        
        while(n-->0) fast = fast.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return dummyHead.next;
    }
}