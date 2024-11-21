

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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        ListNode Head=new ListNode(0);
        ListNode end=Head;
        if(n==0)
        {
        	return null;
        }
        
        int count=0;
        for(int i=0;i<n;i++)
        {
        	ListNode cur=lists[i];
        	while (cur!=null)
        	{
        		count++;
        		cur=cur.next;
        	}
        }
        
        int num=0;
        while(num<count)
        {
        	int minVal=Integer.MAX_VALUE;
        	int p=-1;
        	for(int i=0;i<n;i++)
        	{
        		if(lists[i]==null)
        		{
        			continue;
        		}
        		if(lists[i].val<minVal)
        		{
        			minVal=lists[i].val;
        			p=i;
        		}        		
        	}
        	ListNode temp=lists[p].next;
    		lists[p].next=null;
    		end.next=lists[p];
    		end=end.next;
    		lists[p]=temp;
    		num++;
        }    
        return Head.next;
    }
}
