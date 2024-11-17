import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[]ans=new int[n];
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
        	int x=temperatures[i];
        	while(!deque.isEmpty()&&x>temperatures[deque.peek()])
        	{
        		ans[deque.peek()]=i-deque.peek();
        		deque.pop();
        	}
        	deque.push(i);
        }
        return ans;
    }
}