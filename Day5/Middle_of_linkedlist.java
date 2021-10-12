class Solution {
    public ListNode middleNode(ListNode head) {
        
//         //Bruteforce --> O(n) time and o(1) space
//         //Idea is to calculate the length of linkedlist and move the pointer to half of the length from head;
        
//         ListNode curr = head;
//         int length = 0;
        
//         while(curr != null){
//             curr = curr.next;
//             length++;
//         }
        
//         curr = head;
//         int toMove = length/2;
//         while(toMove-->0){
//             curr = curr.next;
//         }
//         return curr;
        
        
        // Optimal solution ---> O(n) time and O(1) space
        // Idea is to use slow and fast pointer
        
        if(head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;    
        }
        
        return slow;
    }
}