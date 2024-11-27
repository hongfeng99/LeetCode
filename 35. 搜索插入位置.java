class Solution {
    public int searchInsert(int[] nums, int target) {
       int n=nums.length;
       int low=0;
       int high=n-1;
       if(target<nums[0])
       {
    	   return 0;
       }
       if(target>nums[n-1])
       {
    	   return n;
       }
       while(low<=high)
       {
    	   int mid=(low+high)/2;
    	   if(nums[mid]==target)
    	   {
    		   return mid;
    	   }
    	   if(nums[mid]<target)
    	   {
    		   low=mid+1;
    	   }
    	   else
    	   {
    		   high=mid-1;
    	   }
       }
       return low;
    }
}
