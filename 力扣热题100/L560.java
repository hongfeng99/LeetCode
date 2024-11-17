package 力扣热题100;

import java.util.Arrays;

public class L560 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
        	int sum=0;
        	for(int j=i;j<n;j++)
        	{
        		sum+=nums[j];
        		if(sum==k)
        		{
        			count++;
        		}
        	}
        }
        return count;
    }
}