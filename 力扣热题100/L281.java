







123456789
698437126

class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;        
        while(low<high)
        {
        	int count=0;
        	int mid=(low+high)/2;
        	for(int i=0;i<n;i++)
        	{
        		if(nums[i]<=mid)
        		{
        			count++;
        		}
        	}
        	if(count==mid)
        	{
        		low=mid+1;
        	}
        	else
        	{
        		high=mid-1;
        		ans=mid;
        	}
        }
        return mid;
    }
}



























class Solution {
    public int findDuplicate(int[] nums) {
    	int n=nums.length;
    	for(int i=0;i<n;i++)
    	{
    		for(int j=i+1;j<n;j++)
    		{
    			if(nums[i]==nums[j])
    			{
    				return nums[i];
    			}
    		}
    	}
    	return -1;
    }
}
