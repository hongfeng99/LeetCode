class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
        	int mid=(low+high)/2;
        	if(nums[mid]==target)
        	{
        		return mid;
        	}
        	if(nums[0]<=target)
        	{
        		if(nums[mid]>target)
        		{
        			high=mid-1;
        		}
        		else
        		{
        			if(nums[0]<=nums[mid])
        			{
        				low=mid+1;
        			}
        			else
        			{
        				high=mid-1;
        			}
        		}
        	}
        	else
        	{
        		if(nums[mid]>target)
        		{
        			if(nums[mid]>=nums[0])
        			{
        				low=mid+1;
        			}
        			else
        			{
        				high=mid-1;
        			}
        		}
        		else
        		{
        			low=mid+1;
        		}
        	}
        }
        return -1;
    }
}
