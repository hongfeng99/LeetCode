import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>>ans=new ArrayList<List<Integer>>();
    	int n=nums.length;
    	Arrays.sort(nums);
    	if(target>Math.pow(10,9)||target<-Math.pow(10, 9))
    	{
    		return new ArrayList<List<Integer>>();
    	}
    	for(int first=0;first<n;first++)
    	{
    		if(first>0&&nums[first]==nums[first-1])
    		{
    			continue;
    		}
    		for(int second=first+1;second<n;second++)
    		{
    			if(second>first+1&&nums[second]==nums[second-1])
        		{
        			continue;
        		}    			
    			for(int third=second+1;third<n;third++)
    			{
    				int end=n-1;
    				if(third>second+1&&nums[third]==nums[third-1])
    				{
    					continue;
    				}
    				while(third<end&&(long)nums[end]>(long)target-(long)nums[third]-(long)nums[second]-(long)nums[first])
    				{
    					end--;
    				}
    				if(end==third)
    				{
    					continue;
    				}
    				if((long)target-(long)nums[third]-(long)nums[second]-(long)nums[first]==(long)nums[end])
    				{
    					List<Integer> res=new ArrayList<>();
    					res.add(nums[first]);
    					res.add(nums[second]);
    					res.add(nums[third]);
    					res.add(nums[end]);
    					ans.add(res);
    				}
    			}
    		}
    	}
    	return ans;
    }
}
