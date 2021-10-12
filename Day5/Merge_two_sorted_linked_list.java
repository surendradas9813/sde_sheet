class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        
//         // Bruteforce --> O(n+m) time and O(n+m) space for another list
//         // Idea is to use compare the values of two list and put in the separate list and move the pointers in the given list accordingly
        
//         ListNode temp1 = l1;
//         ListNode temp2 = l2;
        
//         ListNode dummyHead = new ListNode(-1);
//         ListNode current = dummyHead;
        
//         while(temp1 != null && temp2 != null){
            
//             if(temp1.val < temp2.val){
//                 current.next = new ListNode(temp1.val);
//                 temp1 = temp1.next;
//             }
//             else{
//                 current.next = new ListNode(temp2.val);
//                 temp2 = temp2.next;
//             }
//             current = current.next;
//         }
        
//         if(temp1 != null){
//             current.next = temp1;
//         }
//         if(temp2 != null){
//             current.next = temp2;
//         }
//         return dummyHead.next;
        
        
        //Optimal -> O(n+m) time and O(1) space and using the same given lists and making them into single list
        // Idea is to make res point to the smallest number among both the given list and traverse one list by comparing the first value
        // of another list and when we encounter larger value we swap the pointers after connecing them and continue the same process and               // finally return res;
        
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        if(head1.val > head2.val){
            ListNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        
        ListNode res = head1;
        
        while(head1 != null && head2 != null){
            
            ListNode tmp = null;
            
            while(head1 != null && head1.val <= head2.val){  // its looks like O(n2) but if we look closely we traversing O(n+m) i.e. only once                                                                 //though a list
                tmp = head1;
                head1 = head1.next;
            }
            
            tmp.next = head2;
            
            ListNode swap = head1;
            head1 = head2;
            head2 = swap;
        }
        return res;
    }
}