package 力扣热题100;

import java.util.Map;

public class L138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*
//Definition for a Node.
class Node {
 int val;
 Node next;
 Node random;

 public Node(int val) {-
     this.val = val;
     this.next = null;
     this.random = null;
 }
}
*/

class Solution {
	Map<Node,Node>map=new HashMap<>();
 public Node copyRandomList(Node head) {
     
    	 if(head==null)
    	 {
    		 return null;
    	 }
    	 if(!map.containsKey(head))
    	 {
    		 Node newhead=new Node(head.val);
    		 map.put(head, newhead);
    		 newhead.next=copyRandomList(head.next);
    		 newhead.random=copyRandomList(head.random);
    	 }
    	 return map.get(head);
 }
}