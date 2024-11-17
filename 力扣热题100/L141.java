package 力扣热题100;

public class L141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode>set=new HashSet<>();
        while(head!=null)
        {
        	if(set.contains(head))
        	{
        		return true;
        	}
        	set.add(head);
        	head=head.next;
        }
        return false;
    }
}



