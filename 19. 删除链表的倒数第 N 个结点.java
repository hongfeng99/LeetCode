/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode Head=new ListNode(0);
        Head.next=head;        
        int count=0;
        ListNode cur=head;
        while(cur!=null)
        {
        	count++;
        	cur=cur.next;
        }
        cur=Head;
        int ptr=0;
        while(ptr<count-n)
        {
        	cur=cur.next;
        	ptr++;
        }
        ListNode next=cur.next;
        cur.next=null;
        cur.next=next.next;
        next.next=null;
        return Head.next;
    }
    
}
///////////////另一种用哈希表存储次序+链表节点的做法
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map=new HashMap<>();
        int count=0;
        ListNode p=new ListNode(0);
        p.next=head;
        while(head!=null)
        {
            count++;
        	map.put(count,head);        	
        	head=head.next;
        }
        int target=count-n+1;
        if(count-n+1==1)
        {
        	p.next=p.next.next;
        	return p.next;
        }
        else
        {
        	map.get(count-n+1-1).next=map.get(count-n+1).next;
        	return p.next;
        }
    }
}





