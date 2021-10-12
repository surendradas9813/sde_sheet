// Three variations of questions. See properly


//first one
class Solution {
    public void deleteNode(ListNode node) {
        
        // O(1) solution
        // Idea is to copy the value of next node into current node;
        // copy the address of next of next node 
        // and the desired output is obtained
        
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}



//Second one
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        
        // O(n) time and O(1) space
        // Idea is to traverse the list and and just manipulate the addresses when match is foung.
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode iterator = dummyHead;
        
        while(iterator.next != null){
            
            if(iterator.next.val == val){
                iterator.next = iterator.next.next;
            }
            else{
                iterator = iterator.next;
            }
        }
        return dummyHead.next;
    }
}




//ThirdOne
class Solutions
{
    static void linkdelete(Node head, int M, int N)
    {
        
        Node curr = head;
        
        while(curr != null){
            
            Node tail = curr;
            
            for(int i=0; i<M-1 && tail != null ; i++)
                tail = tail.next;
                
            if(tail == null) return;
            
            Node mouth = tail;
            
            for(int i=0; i<=N && mouth != null; i++)
                mouth = mouth.next;
                
            tail.next = mouth;
            curr = mouth;
        }
    }
}
