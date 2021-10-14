// 2 variations 

// 1 leetcode 430
class Solution {
    public Node flatten(Node head) {
        
        if(head == null) return head;
        
        Node curr = head;
        
        while(curr != null){
            if(curr.child == null){
                curr = curr.next;
                continue;
            }
            
            Node iter = curr.child;
            
            while(iter.next != null){
                iter = iter.next;
            }
            
            iter.next = curr.next;
            if(curr.next != null) curr.next.prev = iter;
            
            curr.next = curr.child;
            curr.next.prev = curr;
            curr.child = null;
        }
        return head;
    }
}





2) gfg

class GfG
{
    Node flatten(Node root)
    {
	 if(root == null || root.next == null) return root;
	 
	 root.next = flatten(root.next);
	 
	 root = merge(root,root.next);
	 
	 return root;
    }
    
    Node merge(Node l1, Node l2){
        if(l1.data > l2.data){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        Node res = l1;
        
        while(l1 != null && l2 != null){
            
            Node tmp = null;
            
            while(l1 != null && l1.data <= l2.data){
                tmp = l1;
                l1 = l1.bottom;
            }
            
            tmp.bottom = l2;
            
           Node swap = l1;
            l1 = l2;
            l2 = swap;
        }
        
        return res;
    } 
}