package 力扣热题100;
import java.util.*;
public class L438 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		s.nextLine();
		for(int i=0;i<m;i++)
		{			
			String a=new String();
			a=s.nextLine();
			String b=new String();
			b=s.nextLine();
			System.out.println(test(a,b));
		}

	}
}	
	
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        if(n<m)
        {
        	return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<>();
        int[]scount=new int[26];
        int[]pcount=new int[26];
        for(int i=0;i<m;i++)
        {
        	scount[s.charAt(i)-'a']++;
        	pcount[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(scount, pcount))
        {
        	ans.add(0);
        }
        for(int i=m;i<n;i++)
        {
        	scount[s.charAt(i-m)-'a']--;
        	scount[s.charAt(i)-'a']++;
        	if(Arrays.equals(scount, pcount))
        	{
        		ans.add(i-m+1);
        	}
        }
        return ans;
    }
}