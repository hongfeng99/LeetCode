package 力扣热题100;

public class L25 {

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
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(k==1)
    	{
    		return head;
    	}
        ListNode ans=new ListNode(0);
        ans.next=head;
        int count=0;
        ListNode p=head;
        while(p!=null)
        {
        	count++;
        	p=p.next;
        }
        int sum=1;
        int time=count/k;
        ListNode pre=head;
        ListNode cur=head.next;
        while(sum<=time*k)
        {
        	int start=1;
        	while(sum<start*k)
        	{
        		ListNode s=cur.next;
        		cur.next=pre;
        		pre=cur;
        		cur=s;
        		sum++;
        		if(sum==start*k)
        		{
        			start++;
        			s=s.next;
        			cur=cur.next;
        			pre=pre.next;
        		}
        	}
        	
        }
        return head;
    }
}


