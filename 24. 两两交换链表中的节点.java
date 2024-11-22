

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
    public ListNode swapPairs(ListNode head) {
        ListNode Head=new ListNode(0);
        ListNode cur=Head;
        Head.next=head;
        while(cur.next!=null&&cur.next.next!=null)
        {
        	ListNode end=cur.next.next;
        	ListNode newbegin=end.next;
        	end.next=null; 
        	end.next=cur.next;
        	cur.next=null;
        	cur.next=end;
        	cur=end.next;
        	cur.next=newbegin;        	
        }
        return Head.next;
    }
}
