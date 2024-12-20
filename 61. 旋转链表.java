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
    public ListNode rotateRight(ListNode head, int k) {
        int count=0;       
        ListNode Head=new ListNode(0);
        Head.next=head;
        ListNode end=Head;
        while(end.next!=null)
        {
        	count++;
        	end=end.next;
        }
        if(count==0)
        {
        	return head;
        }
        if(k%count==0)
        {
        	return head;
        }
        ListNode ptr=Head;
        int num=0;
        while(num<count-k%count)
        {
        	ptr=ptr.next;
        	num++;
        }
        ListNode newhead=ptr.next;
        ptr.next=null;
        end.next=head;
        return newhead;
    }
}
///////////////////////////更清楚的写法
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
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null||head.next==null||k==0)
    	{
    		return head;
    	}
    	ListNode head1=head;
    	ListNode head2=head;
    	int count=0;
    	int n=1;
    	while(head1.next!=null)
    	{
    		head1=head1.next;
    		n++;          // head1此时指向末尾结点
    	}                 //n此时为链表的总长度
    	int k1=k%n;
    	int k2=n-k1;     //新的头结点之前有k2个结点
    	while(count<k2-1)
    	{
    		head2=head2.next;
    		count++;
    	}                  //此时的head2指向第k2个结点
    	ListNode newHead=head2.next;
    	head2.next=null;
    	head1.next=head;
    	return newHead;
    	
    }
}

