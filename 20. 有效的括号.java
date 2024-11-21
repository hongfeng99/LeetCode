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
