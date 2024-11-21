import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int n=s.length();
       
        Map<Character,Integer>map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if(n==1)
        {
        	return map.get(s.charAt(0));
        }
        int i=0;
        int ans=0;
        while(i<n-1)
        {
        	if(map.get(s.charAt(i))>=map.get(s.charAt(i+1)))
        	{
        		if(i==n-2)
        		{
        			ans+=map.get(s.charAt(i));
        			ans+=map.get(s.charAt(i+1));
        			i++;
        		}
        		else
        		{
        			ans+=map.get(s.charAt(i));
            		i++;	
        		}
        		
        	}
        	else
        	{
        		ans+=map.get(s.charAt(i+1));
        		ans-=map.get(s.charAt(i));
        		i+=2;
        		if(i==n-1)
        		{
        			ans+=map.get(s.charAt(i));
        		}
        	}
        }
        return ans;
    }
}
