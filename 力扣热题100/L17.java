import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
    }
    
    public void backtrack(List<String> ans,StringBuffer res,Map<Integer,String>map,String digits)
    {
    	if(res.length()==digits.length())
    	{
    		ans.add(res.toString
    		return;
    	}
    	for(int i=0;i<digits.length();i++)
    	{
    		for(int j=0;j< )
    		res.add(map.get(digits[i]).charAt());
    	}
    }
}





















class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> combinations=new ArrayList<String>();
    	if(digits.length()==0)
    	{
    		return combinations;
    	}
    	Map<Character,String> map=new HashMap<Character,String>();
    	map.put('2',"abc");
    	map.put('3',"def");
    	map.put('4',"ghi");
    	map.put('5',"jkl");
    	map.put('6',"mno");
    	map.put('7',"pqrs");
    	map.put('8',"tuv");
    	map.put('9',"wxyz");
    	backtrack(combinations,new StringBuffer(),map,0,digits);
    	return combinations;
    }
    public void backtrack(List<String> combinations,StringBuffer combination,Map<Character,String>map,int index,String digits)
    {
    	if(index==digits.length())
    	{
    		combinations.add(combination.toString());
    	}
    	else
    	{
    		String letters=map.get(digits.charAt(index));
        	for(int i=0;i<letters.length();i++)
        	{        		
        		combination.append(letters.charAt(i));
        		backtrack(combinations,combination,map,index+1,digits);
        		combination.deleteCharAt(index);
        	}    		
    	}

    }
}
