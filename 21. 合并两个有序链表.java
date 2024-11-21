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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode Head=new ListNode(0);
        ListNode cur=Head;
        if(list1==null)
        {
        	return list2;
        }
        if(list2==null)
        {
        	return list1;
        }
        while(list1!=null&&list2!=null)
        {
        	if(list1.val<list2.val)
        	{
        		ListNode temp=list1.next;
        		list1.next=null;
        		cur.next=list1;
        		cur=cur.next;
        		list1=temp;
        	}
        	else
        	{
        		ListNode temp=list2.next;
        		list2.next=null;
        		cur.next=list2;
        		cur=cur.next;
        		list2=temp;
        	}
        }
        if(list1!=null)
        {
        	cur.next=list1;
        }
        if(list2!=null)
        {
        	cur.next=list2;
        }
        return Head.next;
    }
}
/////////////////消耗内存更少的写法

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {                
        ListNode head=new ListNode(0);
        ListNode begin=head;
        while(list1!=null&&list2!=null)
        {
        	if(list1.val<list2.val)
        	{
        		head.next=list1;        		
        		list1=list1.next;
        	}
        	else
        	{
        		head.next=list2;
        		list2=list2.next;
        	}
        	head=head.next;
        }
        if(list1!=null)
        {
        	head.next=list1;
        }
        else
        {
        	head.next=list2;
        }return begin.next;
    }
}


