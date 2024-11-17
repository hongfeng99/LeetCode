 package 力扣热题100;

public class L206 {

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
    public ListNode reverseList(ListNode head) {     
        ListNode pre=null;
        ListNode cur=head;
        
        while(cur!=null)
        {
        	ListNode temp=cur.next;
        	cur.next=pre;
        	pre=cur;
        	cur=temp;
        	
        }
        return pre;
    }
}