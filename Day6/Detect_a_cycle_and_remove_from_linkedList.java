class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        
        Node slow = head;
        Node fast = head;
        
        boolean isCyclePresent = false;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                isCyclePresent = true;
                break;
            }
        }
        
        if(isCyclePresent == false) return;
        
        if(slow == head){   // this is for when the first node is only the starting point of loop
            
            while(fast.next != slow)
                fast = fast.next;
            fast.next = null;
        }
        else{
            slow = head;
            
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            
            fast.next = null;
        }
    }
}