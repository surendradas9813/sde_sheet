class Solution {
    public Node copyRandomList(Node head) {
        
//         //Brute-force ---> O(N) time and O(N) extra space
//         // Idea is to use to HashMap
        
//         HashMap<Node,Node> hm = new HashMap<>();
        
//         Node curr = head;
        
//         while(curr != null){
//             hm.put(curr, new Node(curr.val));
//             curr = curr.next;
//         }
        
//         curr = head;
        
//         while(curr != null){
//             hm.get(curr).next = hm.get(curr.next);
//             hm.get(curr).random = hm.get(curr.random);
//             curr = curr.next;
//         }
//         return hm.get(head);
        
        
        
        
        // Optimal solution ----> O(N) time and O(1) extra space
         
            if(head == null) return null;
            Node iter = head, front = null;
        
            // creating nodes and maintaing next pointers
            while(iter != null){
                front = iter.next;
                iter.next = new Node(iter.val);
                iter.next.next = front;
                iter = front;
            }
        
            iter = head;
        
            // mainting random pointers in the copy of linked list
            while(iter != null){
                if(iter.random != null) iter.next.random = iter.random.next;
                
                iter = iter.next.next;
            }
        
            Node dummyHead = new Node(-1);
            
            Node curr = dummyHead;
        
            iter = head;
        
            // retaining the next pointer of original list
            while(iter != null){
                curr.next = iter.next;
                front = iter.next.next;
                iter.next = front;
                iter = iter.next;
                curr = curr.next;
            }
        
            return dummyHead.next;
    }
}