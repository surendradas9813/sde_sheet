public class Solution {
    public ListNode detectCycle(ListNode head) {
        
//         //Bruteforce--> O(N) time and O(N) space complexity
//         //Idea is to use HashSet so whenver the node is encountered which is already in the hashset then it must be the starting point;
        
//         HashSet<ListNode> hs = new HashSet<>();
        
//         ListNode curr = head;
        
//         while(curr != null){
//             if(hs.contains(curr)) return curr;
            
//             else hs.add(curr);
//             curr = curr.next;
//         }
//         return null;
        
        
        //Optimal Approach --> O(N) time and O(1) space complexity
        //Idea is to use slow and fast pointer
        
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) 
                break;
        }
        
        if(slow == fast){  // if cycle is present;
            
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}