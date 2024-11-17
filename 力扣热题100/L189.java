package 力扣热题100;

public class L189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k%n==0)
        {
        	return;
        }
        else
        {
        	int[] lowtemp=new int[n-k%n]; //保存前半部分
        	int[] hightemp=new int[k];  //保存最后k位
        	for(int i=n-k%n;i<n;i++)
        	{
        		hightemp[i-(n-k%n)]=nums[i];
        	}
        	for(int i=0;i<n-k%n;i++)
        	{
        		lowtemp[i]=nums[i];
        	}
        	
        	for(int i=0;i<n-k%n;i++)
        	{
        		nums[i+k%n]=lowtemp[i];        		
        	}
        	for(int i=0;i<k%n;i++)
        	{
        		nums[i]=hightemp[i];
        	}   	       	
        }
    }
}


