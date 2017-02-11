//138. Copy List with Random Pointer
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointers {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null) {
            return null;
        }
        
        RandomListNode curr= head, next;
        
        //create copies
        while(curr != null) {
            
            next=curr.next;
            RandomListNode newNode=new RandomListNode(curr.label);
            curr.next=newNode;
            newNode.next=next;
            
            curr=next;
        }
        
        //assign random pointers to new nodes
        curr=head;
        
        while(curr != null) {
            
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr=curr.next.next;
        }
        
        //break the list into 2 - original and new list
        RandomListNode newHead=new RandomListNode(0);
        RandomListNode copyCurr=newHead;
        
        curr=head;
        while(curr != null) {
            
            next=curr.next.next;
            
            //new list
            copyCurr.next=curr.next;
            copyCurr=copyCurr.next;
            
            //old list
            curr.next=next;
            
            curr=next;
        }
        
        return newHead.next;
    }
}
