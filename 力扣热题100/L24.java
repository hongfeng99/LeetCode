package 力扣热题100;

public class L24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



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
    	if(head==null||head.next==null)
    	{
    		return head;
    	}
    	else
        {
    		ListNode x=head.next;
    		head.next=x.next;
    		x.next=head;
    		
    		ListNode p=head;
    		ListNode q=new ListNode(0);
    		while(p.next!=null&&p.next.next!=null)
    		{
    			q=p.next;            	
            	p.next=q.next;
            	q.next=q.next.next;
            	p.next.next=q;
            	p=q;
            	q=q.next;            	
    		}
    		return x;
        	
        }
    }
}