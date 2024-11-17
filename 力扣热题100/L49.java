package 力扣热题100;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class L49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<List<String>> groupAnagrams(String[] strs) {
		int n=strs.length;
		List<List<String>> ans=new ArrayList<List<String>>();
		boolean [] dp=new boolean[n];//标记这个位置是否已经被使用了
		for(int i=0;i<n;i++)
		{
			if(dp[i]==true)
			{
				continue;
			}
			List<String> temp=new ArrayList<String>();
			dp[i]=true;
			temp.add(strs[i]);
			for(int j=i+1;j<n;j++)			
			{
				if(dp[j]==true)
				{
					continue;
				}
				if(test(strs[i],strs[j])==true)
				{
					temp.add(strs[j]);
					dp[j]=true;
				}
			}
			ans.add(temp);
		}
		return ans;       
    }
	
	public static boolean test(String a,String b)
	{
		int n1=a.length();
		int n2=b.length();
		if(n1!=n2)
		{
			return false;
		}
		
		char[] a1=a.toCharArray();
		char[] b1=b.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(b1);
		
		for(int i=0;i<n1;i++)
		{
			if(a1[i]!=b1[i])			
			{
				return false;
			}
			
		}
		return true;
	}
	
}
