package 力扣热题100;

import java.util.List;

public class L2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


///以下是错误版本 溢出
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
    	List<Integer>list1=new ArrayList<>();
    	List<Integer>list2=new ArrayList<>();
    	ListNode p1=l1;
    	ListNode p2=l2;
    	while(p1!=null)
    	{
    		list1.add(p1.val);
    		p1=p1.next;
    	}
    	while(p2!=null)
    	{
    		list2.add(p2.val);
    		p2=p2.next;
    	}
    	int n1=list1.size();
    	int n2=list2.size();
    	int p=0;
    	int num1=0;
    	int num2=0;
    	int mult=1;
    	while(p<n1)
    	{    		
    		num1+=mult*list1.get(p);
    		p++;
    		mult*=10;
    	}
    	p=0;
    	mult=1;
    	while(p<n2)
    	{    		
    		num2+=mult*list2.get(p);
    		p++;
    		mult*=10;
    	}
    	int num=num1+num2;    	   
    	ListNode ans=new ListNode(0);
    	ListNode head=ans;
    	while(num!=0)
    	{
    		head.next=new ListNode(num%10);
    		num/=10;
    		head=head.next;
    	}
        if(n1==1&&n2==1&&l1.val==0&&l2.val==0)
        {
            return new ListNode(0);
        }
    	return ans.next;
    	
    }
}

///////////////////////  会发生溢出错误
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
        ListNode p1=l1;
        ListNode p2=l2;
        long num1=0;
        long num2=0;
        long mult=1;
        while(p1!=null)
        {
        	num1+=mult*(p1.val);
        	mult*=10;
        	p1=p1.next;
        }
        mult=1;
        while(p2!=null)
        {
        	num2+=mult*(p2.val);
        	mult*=10;
        	p2=p2.next;
        }
        long num=num1+num2;
        
        ListNode ans=new ListNode(0);
        ListNode p=ans;
        while(num!=0)
        {
        	p.next=new ListNode(num%10);
        	p=p.next;
        	num/=10;
        }
        if(l1.val==0&&l1.next==null&&l2.val==0&&l2.next==null)
        {
        	return new ListNode(0);
        }
        return ans.next;
        
    }
}

//////////////////////我自己原创的正确答案

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
        int jinwei=0;
        ListNode ans=new ListNode(0);
        ListNode p=ans;
        while(l1!=null&&l2!=null)
        {
        	p.next=new ListNode((l1.val+l2.val+jinwei)%10);
        	p=p.next;
        	jinwei=(l1.val+l2.val+jinwei)/10;
        	l1=l1.next;
        	l2=l2.next;
            if(l1==null&&l2==null&&jinwei==1)
            {
                p.next=new ListNode(1);
            }
        }
        while(l1!=null)
        {
        	 p.next=new ListNode((l1.val+jinwei)%10);
        	 p=p.next;
        	 jinwei=(l1.val+jinwei)/10;
        	 l1=l1.next;
             if(l1==null&&jinwei==1)
             {
                p.next=new ListNode(1);
             }
        }
        while(l2!=null)
        {
        	p.next=new ListNode((l2.val+jinwei)%10);
        	p=p.next;
        	jinwei=(l2.val+jinwei)/10;
        	l2=l2.next;
            if(l2==null&&jinwei==1)
             {
                p.next=new ListNode(1);
             }
        }return ans.next;
    }
}

