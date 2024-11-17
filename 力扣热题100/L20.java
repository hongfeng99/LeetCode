import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2==1)
        {
        	return false;
        }
        Stack<Character>stack=new Stack<>();
        int p=0;
        Map<Character,Character>map=new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        while(p<n)
        {
        	if(map.containsKey(s.charAt(p)))
        	{
        		stack.push(s.charAt(p));
        	}
        	else
        	{
        		if(map.get(stack.pop())!=s.charAt(p))
        		{
        			return false;
        		}
        	}
        	p++;
        }
        return stack.isEmpty();
    }
}






















class Solution {
    public boolean isValid(String s) {
    	Map<Character,Character> map=new HashMap<Character,Character>();
    	map.put(')','(');
    	map.put(']','[');
    	map.put('}','{');
    	// Stack<Character> stack=new Stack<Character>();
        Deque<Character> stack = new LinkedList<Character>();
    	int n=s.length();
    	for(int i=0;i<n;i++)
    	{
    		if(map.containsKey(s.charAt(i)))
    		{
    			if(!stack.isEmpty()&&stack.peek()==map.get(s.charAt(i)))
    			{
    				stack.pop();
    			}
    			else
    			{
    				return false;
    			}
    		}
    		else
    		{
        		stack.push(s.charAt(i));    			
    		}

    	}
    	if(stack.isEmpty())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
}
}