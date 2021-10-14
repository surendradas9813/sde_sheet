public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //Bruteforce--> O(n^2) time and O(1);
        //Idea is to two nested loops and find the same node at which they meet
        
        
//         //Another Approach ---> O(n) time and O(n) space
//         // Idea is to use HashSet
        
//         HashSet<ListNode> hs = new HashSet<>();
        
//         while(headA != null){
//             hs.add(headA);
//             headA = headA.next;
//         }
        
//         while(headB != null){
//             if(hs.contains(headB))
//                 return headB;
//             else
//                 headB = headB.next;
//         }
//         return null;
        
        
        // Optimal Apprach --> O(n) time and O(1) space
        // Idea is to traverse the both the array simultaneuosly and exchange the pointer when anyone reach null;
        
        
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        while(temp1 != temp2){
            if(temp1 == null)
                temp1 = headB;
            else
                temp1 = temp1.next;
            
            if(temp2 == null)
                temp2 = headA;
            else
                temp2 = temp2.next;
        }
        return temp1;
            
            
    }
}