import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
        	map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        List<Integer> ans=new ArrayList<Integer>();
        int i=0;
        while(i<n)
        {
        	int num=0;
        	int allnum=0;
        	Set<Character> temp=new HashSet<Character>();
        	while(num==0||(num>0&&num<allnum))
        	{
        		if(temp.contains(s.charAt(i)))
        		{     
        			num++;
        		}
        		else
        		{
        			num++;
        			temp.add(s.charAt(i));
        			allnum+=map.get(s.charAt(i));
        		}
        		i++;
        	}
        	ans.add(allnum);
        }
        return ans;
    }
}