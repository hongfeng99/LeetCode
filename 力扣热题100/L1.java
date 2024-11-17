package 力扣热题100;
import java.util.*;
public class L1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		for(int i=0;i<m;i++)
		{
			int n=s.nextInt();
			int target=s.nextInt();
			int []a=new int[n];
			for(int j=0;j<n;j++)
			{
				a[j]=s.nextInt();
			}
			System.out.println(Arrays.toString(test(a,target)));
			
		}

	}
	
	public static int[] test(int a[],int target)
	{
		int[] ans=new int[2];
		int n=a.length;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			map.put(a[i],i);
		}
		
		for(int i=0;i<n;i++)
		{
			if(map.containsKey(target-a[i])&&map.get(target-a[i])!=i)
			{
				ans[0]=i;
				ans[1]=map.get(target-a[i]);
				return ans;
			}
		}
		return new int[] {-1,-1};
		
	}
	

}
