class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        
        //Optimal Approach--> O(N) time and O(1) space complexity
        //Idea is to connect the last node to first node and move the pointer from head node to length-(k%length) node and make ist next null;
        
        if(head == null) return head;
        
        int length = 1;
        
        ListNode curr = head;
        
        while(curr.next != null){
            length++;
            curr = curr.next;
        }
        
        curr.next = head; // connecting last node to first node
        
        int toMove = length- (k%length);   // since k may be multiple rotations
        
        curr = head;
        ListNode prev = null;
        
        while(toMove-->0){
            prev = curr;
            curr = curr.next;     
        }
        prev.next = null;
        return curr;
        
    }
}