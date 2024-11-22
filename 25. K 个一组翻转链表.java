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
        ListNode Head=new ListNode(0);
        Head.next=head;
        ListNode x=head;
        int count=0;
        while(x!=null)
        {
        	count++;
        	x=x.next;
        }
//        if(k==1)
//        {
//        	if(count==1)
//        	{
//        		return head;
//        	}
//        	if(count==2)
//        	{
//        		ListNode y=head.next;
//        		y.next=head;
//        		head.next=null;
//        		return y;
//        	}
//        	else
//        	{
//        		ListNode pre=null;
//        		ListNode cur=head;
//        		while(cur!=null)
//        		{
//        			ListNode temp=cur.next;
//        			cur.next=pre;
//        			pre=cur;
//        			cur=temp;
//        		}
//        		return pre;
//        	}
//        }
//        
        if(k==1)
        {
        	return head;
        }
        if(k==2)
        {
        	ListNode cur=Head;
        	while(cur.next!=null&&cur.next.next!=null)
        	{
        		ListNode end=cur.next.next;
        		ListNode newbegin=end.next;
        		
        		end.next=cur.next;
        		cur.next=end;
        		end.next.next=newbegin;
        		cur=end.next;
        	}
        	return Head.next;
        }
        
        else
        {
        	int sum=0;//用sum代表处理过的小组的数量
        	int times=count/k;//times代表一共需要处理count/k组
        	ListNode pre=head;
    		ListNode cur=head.next;//用pre和cur来进行每一个小组内部的反转
    		ListNode end=Head;//用end标记每一个待处理小组初始的第一个结点前面的结点（它来自前面一组）
    		ListNode newend=new ListNode(0);//用newend标记每一个待处理小组初始的第一个结点
        	while(sum<times)
        	{
        		int num=0;   
        		newend=end.next;
        		pre=end.next;
        		cur=pre.next;
        		while(num<k-1)
        		{
        			ListNode temp=cur.next;
        			cur.next=pre;
        			pre=cur;
        			cur=temp;
        			num++;
        		}
        		end.next=pre;
        		newend.next=cur;
        		end=newend;
        		sum++;
        	}
        	return Head.next;
        }
    }
}
