package 力扣热题100;

import java.util.List;

public class L15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> threeSum(int[] nums)
	 {
		 int n=nums.length;
		 Arrays.sort(nums);
		 int i=0;
		 int j=0;
		 int k=0;
		 List<List<Integer>> ans=new ArrayList<List<Integer>>();
		 for(i=0;i<n;i++)
		 {
			 if(i>0&&nums[i]==nums[i-1])
			 {
				 continue;
			 }
			 k=n-1;
			 for(j=i+1;j<n;j++)
			 {
				 if(j>i+1&&nums[j]==nums[j-1])
				 {
					 continue;
				 }
				 while(j<k&&nums[k]+nums[j]+nums[i]>0)
				 {
					 k--;
					 if(j==k)
					 {
						 break;
					 }
				 }
				 if(j==k)
				 {
					 break;
				 }
				 if(nums[j]+nums[k]+nums[i]==0)
				 {
					 List<Integer> temp=new ArrayList<>();
					 temp.add(nums[i]);
					 temp.add(nums[j]);
					 temp.add(nums[k]);
					 ans.add(temp);
				 }
			 }
		 }
		 return ans;
	 }

}



