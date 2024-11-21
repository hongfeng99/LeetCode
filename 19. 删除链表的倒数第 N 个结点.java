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
