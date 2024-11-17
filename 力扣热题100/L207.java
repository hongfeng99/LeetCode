import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
        	map.put(prerequisites[i][0], prerequisites[i][1]);
        }
        
        for(int i=0;i<numCourses;i++)
        {
        	if(!map.containsKey(i))
        	{
        		continue;
        	}
        	else
        	{
        		Set<Integer> set=new HashSet<>();
        		if(func(0,i,set,map)==false)
            	{
            		return false;
            	}
        	}
        	
        }
        return true;
    }
    //x是hashmap中需要检查的第x个元素,这个函数检验第x个元素是否合格
    public Boolean func(int begin, int x,Set<Integer> set,Map<Integer,Integer>map)
    {
    	if(begin==0)
    	{
    		if(!map.containsKey(map.get(x)))
    		{
    			return true;	
    		}
    		else
    		{
    			set.add(x);
    			x=map.get(x);
    		}
    	}
    	else
    	{
    		if(set.contains(x))
    		{
    			return false;
    		}
    		else
    		{
    			if(map.containsKey(x))
    			{
    				set.add(x);
        			x=map.get(x);
        			func(begin++,x,set,map);
    			}
    			else
    			{
    				return true;
    			}
    		}
    	}
	    return false;	
    }
}