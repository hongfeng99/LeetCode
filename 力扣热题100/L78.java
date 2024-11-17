import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> combinations=new ArrayList<List<Integer>>();
    	List<Integer>combination=new ArrayList<Integer>();
    	backtrack(combinations,combination,nums,0);
    	return combinations;
    }
    public void backtrack(List<List<Integer>> combinations,List<Integer>combination,int[]nums,int begin)
    {
    		combinations.add(new ArrayList<Integer>(combination));

    	for(int i=begin;i<nums.length;i++)
    	{
    		if(combination.contains(nums[i]))
    		{
    			break;
    		}
    		combination.add(nums[i]);
    		backtrack(combinations,combination,nums,begin+1);
    		combination.remove(combination.size()-1);
    	}
    }
}





























class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int n=nums.length;
        backtrack(res,new ArrayList<Integer>(),nums,0,n);
        return res;
    }
    public void backtrack(List<List<Integer>>combinations,List<Integer>combination,int []nums,int start,int n)
    { 
    	combinations.add(new ArrayList<Integer>(combination));
		for(int j=start;j<n;j++)
		{
			combination.add(nums[j]);
			backtrack(combinations,combination,nums,j+1,n);
			combination.remove(combination.size()-1);
		}   	
    }
}