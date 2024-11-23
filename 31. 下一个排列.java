import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
    	int n=nums.length;
    	if(n==1)
    	{
    		return;
    	}
    	int ptr=n-1;
    	while(ptr-1>=0&&nums[ptr-1]>=nums[ptr])
    	{
    		ptr--;
    	}
    	if(ptr==0)
    	{
    		Arrays.sort(nums);
    		return;
    	}
    	else
    	{
    		int p=n-1;
    		while(nums[p]<=nums[ptr-1])
    		{
    			p--;
    		}
    		int[]res=new int[n-1-ptr+1];
    		res[n-1-ptr]=nums[ptr-1];
    		nums[ptr-1]=nums[p];
    		int count=0;
    		for(int i=ptr;i<n;i++)
    		{
    			if(i!=p)
    			{
    				res[count]=nums[i];
    				count++;
    			}
    		}
    		Arrays.sort(res);
    		for(int i=0;i<=count;i++)
    		{
    			nums[ptr]=res[i];
    			ptr++;
    		}
    	}
    	return;
    }
}

79874091706912040836126987543
                      7345689
