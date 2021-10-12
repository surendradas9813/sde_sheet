class Solution {
    public ListNode reverseList(ListNode head) {
        
        
//         // Iterative Approach
        
//         if(head == null) return null;
        
//         ListNode curr = head, prev = null, next = null;
        
//         while(curr != null){
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
//         return prev;
        
        
        
        // Recursive Approach
        
        if(head == null || head.next == null) return head;
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}




//Anther variation question
// 1,2,3,4,5  left =2 right=4    o/p: 1,4,3,2,5

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        //Optimal solution
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode curr = dummyHead;
        ListNode prev = null;
        
        while(left-->0){
            prev = curr;
            curr = curr.next;
            right--;
        }
        
        ListNode mouth = curr;
        
        ListNode iter = curr, previous=null, next = null;
        
        for(int i=0; i<right+1; i++){
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        
        prev.next = previous;
        mouth.next = curr;
        
        return dummyHead.next;
        
    }
}