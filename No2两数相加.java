package 力扣超级版本;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(0);
        ListNode ptr=ans;
        int carry=0;
        while(l1!=null&&l2!=null)
        {
        	ListNode temp=new ListNode((l1.val+l2.val+carry)%10);
        	carry=(l1.val+l2.val+carry)/10;
        	ptr.next=temp;
        	ptr=ptr.next;
        	l1=l1.next;
        	l2=l2.next;
        }
        while(l1==null&&l2!=null)
        {
        	ListNode temp=new ListNode((l2.val+carry)%10);
        	carry=(l2.val+carry)/10;
        	ptr.next=temp;
        	ptr=ptr.next;
        	l2=l2.next;
        }
        while(l2==null&&l1!=null)
        {
        	ListNode temp=new ListNode((l1.val+carry)%10);
        	carry=(l1.val+carry)/10;
        	ptr.next=temp;
        	ptr=ptr.next;        	
        	l1=l1.next;
        }
        if(carry==0)
        {
        	ptr.next=null;	
        }
        else
        {
        	ptr.next=new ListNode(1);
        }
        return ans.next;
    }
}