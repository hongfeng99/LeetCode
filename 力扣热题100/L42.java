package 力扣热题100;

import java.util.*;

public class L42 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int[]a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			System.out.println(test(a));
		}

	}
	
	public static int test(int height[]) {
		int n=height.length;
		int[] leftmax=new int[n];
		int[] rightmax=new int[n];
		leftmax[0]=height[0];
		rightmax[n-1]=height[n-1];
		for(int i=1;i<n;i++)
		{
			leftmax[i]=Math.max(leftmax[i-1], height[i]);			
		}
		for(int i=n-2;i>=0;i--)
		{
			rightmax[i]=Math.max(rightmax[i+1], height[i]);
		}
		int count=0;
		for(int i=1;i<n-1;i++)
		{
			count+=(Math.min(rightmax[i], leftmax[i])-height[i]);
		}
		return count;
}

//我的初步思考：从每一个柱子a开始，如果它的下一个柱子b比他矮，并且右方存在高度>=a的柱子,那么有蓄水池。


}