class Solution {
    public boolean canJump(int[] nums) {
      int n=nums.length;
      int p=0;
      int remost=0;
      if(n==1)
      {
    	  return true;
      }
      while(p<n-1)
      {
    	  remost=Math.max(remost, nums[p]+p);
    	  
    	  if(nums[p]==0&&remost==p)
    	  {
    		  return false;
    	  }
    	  if(remost>=n-1)
    	  {
    		  return true;
    	  }
    	  p++;
      }
      return false;
    }
}