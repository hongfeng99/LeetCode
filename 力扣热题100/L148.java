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
    public ListNode sortList(ListNode head) {
        if(head==null)
        {
        	return head;
        }
        ListNode ans=new ListNode(0);
        ans.next=head;
        ListNode cur=head.next;
        ListNode pre2=head;
        while(cur!=null)
        {
        	ListNode begin=ans.next;
        	ListNode pre1=new ListNode(0);
        	while(begin!=null&&begin.val<=cur.val)
        	{
        		pre1=begin;
        		begin=begin.next;
        	}
        	if(begin==ans.next)
        	{
        		pre2.next=cur.next;
        		cur.next=null;
        		cur.next=ans.next;
        		ans.next=cur;
        	}
        	else
        	{
        		pre2.next=cur.next;
        		cur.next=null;
        		cur.next=begin;
        		pre1.next=cur;
        		cur=pre2.next;
        	}
        }
        return ans.next;
    }
}