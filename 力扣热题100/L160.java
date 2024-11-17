package 力扣热题100;

public class L160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Map <ListNode,Boolean> map=new HashMap<>();
    ListNode p1=headA;
    while(p1!=null)
    {
    	map.put(p1,true);
    	p1=p1.next;
    }
    ListNode p2=headB;
    while(p2!=null)
    {
    	if(map.containsKey(p2))
    	{
    		return p2;
    	}
    	p2=p2.next;
    }
    return null;    
    }
    
}