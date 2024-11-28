1 1 2 5 6 7 10

1 1 2 5
	  6
	  7
	  10
	  
1 1 5 6
      7
      10
      
1 1 6//
    7
    10 
      
1 1 7      
    10 
      
1 2 5//    
    6  
    7 
    10  
      
1 5 6      
    7  
    10  
      
1 6 7      
    10  

1 7//    
  10                   1 1 2 5 6 7 10
      
1 2 5 //////////////////////
    6
    7  
    10  
      
1 5 6
	7
	10
	
1 6 7	
	10
	
1 7/////////////////////////	
  10
	








import java.util.Arrays;
import java.util.List;
//1 1 2 5 6 7 10
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> res=new ArrayList<Integer>();
        backtrack(candidates,target,ans,res,0,0);
        return ans;
        
    }
    
    public void backtrack(int candidates[],int target,List<List<Integer>>ans,List<Integer>res,int begin,int sum)
    {
    	if(sum==target)
    	{
    		ans.add(new ArrayList<Integer>(res));
    		return;
    	}
    	if(sum>target)
    	{
    		return; 
    	}    	
    	for(int i=begin;i<candidates.length;i++)
    	{
    		if(i>begin&&candidates[i]==candidates[i-1])//////
    		{
    			continue;
    		}
    		res.add(candidates[i]);
    		sum+=candidates[i];
    		backtrack(candidates,target,ans,res,i+1,sum);
    		res.remove(res.size()-1);
    		sum-=candidates[i];
    	}
    }
}
