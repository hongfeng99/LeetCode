package 力扣热题100;

public class L283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void moveZeroes(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        if(nums[0]==0)
        {
        	dp[0]=1;
        }
        else
        {
        	dp[0]=0;
        }
        int count=dp[0];
        for(int i=1;i<n;i++)
        {
        	if(nums[i]==0)
        	{
        		count++;
        		dp[i]=count;
        	}
        	else
        	{
        		dp[i]=dp[i-1];
        	}
        }
        
        for(int i=0;i<n;i++)
        {
        	if(nums[i]!=0)
        	{
        		nums[i-dp[i]]=nums[i];
        	}
        }
        for(int i=n-count;i<n;i++)
        {
        	nums[i]=0;
        }

    }
	


}
