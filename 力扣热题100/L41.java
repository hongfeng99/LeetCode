package 力扣热题100;

public class L41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



class Solution {
    public int firstMissingPositive(int[] nums) {
     int n=nums.length;
     int mins=nums[0];
    
     int[] test=new int[n+2];
     for(int i=0;i<n;i++)
     {
    	 if(1<=nums[i]&&nums[i]<=n+1)
    	 {
    		 test[nums[i]]=1;
    	 }
     }
     int p=1;
     while(test[p]==1)
     {
    	 p++;
     }
     return p;
    }
}