class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
        	return 1;
        }
        int low=0;
        int high=0;
        while(high<n-1)
        {
        	while(high+1<n&&nums[high]==nums[high+1])
        	{
        		high++;
        	}
        	nums[low]=nums[high];
        	low++;
        	high++;
        }
        if(nums[n-1]==nums[n-2])
        {
        	return low;
        }
        else
        {
        	nums[low]=nums[n-1];
        	return low+1;
        }
    }
}
///////////////////////////更为简洁的写法
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==0)
        {
        	return 0;
        }
        int low=1;
        int high=1;
        while(high<n)
        {
        	if(nums[high]!=nums[high-1])
        	{
        		nums[low]=nums[high];
        		low++;
        	}
        	high++;
        }
        return low;
    }
}
