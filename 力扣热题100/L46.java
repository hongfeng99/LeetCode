import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> combinations=new ArrayList<List<Integer>>();
    	List<Integer> combination=new ArrayList<Integer>();
    	backtrack(combinations,combination,nums);
    	return combinations;
    }
    public void backtrack(List<List<Integer>> combinations,List<Integer>combination,int[]nums)
    {
    	if(combination.size()==nums.length) {
    		combinations.add(new ArrayList<Integer>(combination));
    		return;
    	}
    	for(int i=0;i<nums.length;i++)
    	{
    		if(combination.contains(nums[i]))
    		{
    			continue;
    		}
    		combination.add(nums[i]);
    		backtrack(combinations,combination,nums);
    		combination.remove(combination.size()-1);
    	}
    }
}