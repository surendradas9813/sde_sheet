class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // Bruteforce --> O(N) time and O(N) space
        // Idea is to traverse through the list and store the values in arraylist and later on traverse thruough the arraylist and check for palindrome
        
        
        //Optiomal solution --> O(N) and O(1) space
        //Idea is to reverse the right half and travese through both and compare accordingly and not matched then it is not palindrome;
        //for reversing right half we use slow and fast pointer to find middle and reverse starting from that
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        ListNode reversedHead = reverse(slow);
        
        slow = head;
        
        while(reversedHead != null){
            if(slow.val != reversedHead.val) return false;
            
            slow = slow.next;
            reversedHead = reversedHead.next;
        }
        return true;     
    }
    
    
    public ListNode reverse(ListNode head){
        ListNode curr = head, next = null, prev = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}