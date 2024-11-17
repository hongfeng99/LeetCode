package 力扣热题100;

import java.util.List;

public class L234 {

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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null)
        {
        	list.add(head.val);
        	head=head.next;
        }
        int n=list.size();
        if(n%2==0)
        {
        	int low=n/2-1;
        	int high=n/2;
        	while(0<=low&&high<n&&list.get(low)==list.get(high))
        	{
        		low--;
        		high++;
        	}
        	if(low==-1)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
        else
        {
        	int p=n/2;
        	int count=1;
        	while(0<=p-count&&list.get(p-count)==list.get(p+count))
        	{
        		count++;
        	}
        	if(p-count==-1)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
    }
}








