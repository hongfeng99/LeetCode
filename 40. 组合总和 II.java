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
/////////////////第83行if(i>begin&&candidates[i]==candidates[i-1]) 为什么加i>begin,
因为前一层回溯已经探讨了以：前面一个元素作为已遍历元素的所有情况，这样之前的回溯已经囊括了此时未来拥有的所有情况。
如：1 1 2 5 6 7 10
如：1 2 4 6 7 9 9 11 13 15
    1 2 4 6 7(9 9 11 13 15)
    7的下一个元素取9，已经试过第一个9了，begin一定在9之前。
    如果第二个9不是begin，那么就表明它不是连着取第一个9和第二个9，
    	而是第一个9和之后的已经被完全讨论过了，现在回溯到了第一个9之前的位置。
	7 9(第一个) 11 13 15
    和  7 9(第二个) 11 13 15意义完全一样
    
