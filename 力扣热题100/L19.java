package 力扣热题100;

public class L19 {

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





