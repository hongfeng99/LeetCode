
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int sum=n1+n2;
        if(sum%2==1)
        {
        	return fun(nums1,nums2,sum/2+1);
        }
        else
        {
        	return (fun(nums1,nums2,sum/2+1)+fun(nums1,nums2,sum/2))/2;
        }
    }
    
    public double fun(int[]nums1,int []nums2, int k)
    {
    	int n1=nums1.length;
    	int n2=nums2.length;
    	int pivot1=0;
    	int pivot2=0;
    	int newpivot1=0;
    	int newpivot2=0;
    	while(true)
    	{
    		
    		if(pivot1==n1)
    		{
    			return nums2[pivot2+k-1];
    		}
    		if(pivot2==n2)
    		{
    			return nums1[pivot1+k-1];
    		}
    		if(k==1)
    		{
    			return Math.min(nums1[pivot1], nums2[pivot2]);
    		}
    		int half=k/2;
    		newpivot1=Math.min(n1-1, pivot1+half-1);
    		newpivot2=Math.min(n2-1, pivot2+half-1);
    		if(nums1[newpivot1]<=nums2[newpivot2])
    		{
    			k=k-(newpivot1-pivot1+1);
    			pivot1=newpivot1+1;
    		}
    		else
    		{
    			k=k-(newpivot2-pivot2+1);
    			pivot2=newpivot2+1;
    		}
    	}
    }
}
