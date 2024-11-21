import java.util.Deque;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Map<Character,Character> map=new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Set<Character>set=new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        Deque<Character> deque=new LinkedList<Character>();
        int ptr=1;
        deque.push(s.charAt(0));
        while(ptr<n)
        {
        	if(set.contains(s.charAt(ptr)))
        	{
        		deque.push(s.charAt(ptr));
        	}
        	else
        	{
        		if(deque.poll()!=map.get(s.charAt(ptr)))
        		{
        			return false;
        		}
        	}
        	ptr++;
        }
        if(deque.isEmpty())
        {
        	return true;
        }
        return false;
    }
}
///////////////////哈希表颠倒的做法，更为简洁
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
        		if(stack.isEmpty()||map.get(stack.pop())!=s.charAt(p))
        		{
        			return false;
        		}
        	}
        	p++;
        }
        return stack.isEmpty();
    }
}
