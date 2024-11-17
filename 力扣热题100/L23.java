/////////////////////////以下是错的
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
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        int n=lists.length;
        ListNode[] first=new ListNode[n];
        for(int i=0;i<n;i++)
        {
        	first[i]=lists[i];
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
        	ListNode temp=lists[i];
        	while(temp!=null)
        	{
        		count++;
        		temp=temp.next;
        	}
        }

        int minnum=Integer.MAX_VALUE;
        int minsite=-1;
        int sum=0;
        while(sum<count)
        {
        	int p=0;
        	while(p<n)     //从0遍历到n-1，找最小的那个
        	{
        		if(first[p]!=null&&first[p].val<minnum)        //如果不为空
        		{
        			minnum=first[p].val;  
    				minsite=p;     //寻找最小的那个，用minsite保存他的位置
        		}
        		p++; 
        	}
        	cur.next=first[minsite];
        	cur=cur.next;
        	first[minsite]=first[minsite].next;
        	sum++;
        }
        return ans.next;
    }
}


/////////////////////////////////

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
        int numofnull=0;
        int sum=0;        
        for(int i=0;i<n;i++)
        {
        	if(lists[i]==null)
        	{
        		numofnull++;
        	}
        	else
        	{
        		ListNode x=lists[i];
            	while(x!=null)
            	{
            		sum++;
            		x=x.next;
            	}	
        	}
       	
        }
        
        if(n==0||numofnull==n)
        {
        	return null;
        }
        ListNode[] pointer=new ListNode[n];
        for(int i=0;i<n;i++)
        {
        	pointer[i]=lists[i];
        }        
        int count=0;
        ListNode ans=new ListNode(0);
        ListNode endofans=ans;
        while(count<sum)
        {
            int siteofmin=0;
        	int minValue=Integer.MAX_VALUE;
        	for(int i=0;i<n;i++)
        	{
        		if(pointer[i]==null)
        		{
        			continue;
        		}
        		else
        		{
        			if(pointer[i].val<minValue)
        			{
        				minValue=pointer[i].val;
        				siteofmin=i;        				
        			}
        		}
        	}
        	if(pointer[siteofmin].next==null)
        	{
        		endofans.next=pointer[siteofmin];
        		endofans=endofans.next;
        		pointer[siteofmin]=null;
        	}
        	else
        	{
            	ListNode temp=pointer[siteofmin].next;
            	pointer[siteofmin].next=null;
            	endofans.next=pointer[siteofmin];
            	endofans=endofans.next;
            	pointer[siteofmin]=temp;
        	}
        	count++;
        }
        return ans.next;
    }
}
















