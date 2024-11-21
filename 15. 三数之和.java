import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
         int n=nums.length;
         List<List<Integer>> ans=new ArrayList<List<Integer>>();
         for(int i=0;i<n;i++)
         {
        	 if(i>0&&nums[i]==nums[i-1])
        	 {
        		 continue;
        	 }
        	 int k=n-1;
        	 for(int j=i+1;j<n;j++)
        	 {
        		 if(j>i+1&&nums[j]==nums[j-1])
        		 {
        			 continue;
        		 }
        		 while(j<k&&nums[j]+nums[k]>0-nums[i])
        		 {
        			 k--;
        		 }
        		if(j==k)
        		{
        			continue;
        		}
        		if(nums[j]+nums[k]==-nums[i])
        		{
        			List<Integer> res=new ArrayList<>();
        			res.add(nums[i]);
      				res.add(nums[j]);
      				res.add(nums[k]);
      				ans.add(res); 
        		}
        	 }
         }
         return ans;
    }
}
