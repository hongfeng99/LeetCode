import java.util.Collections;
import java.util.List;

class Solution {
    public String addBinary(String a, String b) {
        int m=a.length();
        int n=b.length();
        List<Integer> ans=new ArrayList<>();
        int jinwei=0;
        int p1=m-1;
        int p2=n-1;
        while(p1>=0&&p2>=0)
        {
        	char x=a.charAt(p1);
        	char y=b.charAt(p2);
        	int num=x-'0'+y-'0'+jinwei;
        	jinwei=num/2;
        	ans.add(num%2);
        	p1--;
        	p2--;
        }
        while(p1>=0)
        {
        	char x=a.charAt(p1);
        	int num=x-'0'+jinwei;
        	jinwei=num/2;
        	ans.add(num%2);
        	p1--;
        }
        while(p2>=0)
        {
        	char y=b.charAt(p2);
        	int num=y-'0'+jinwei;
        	jinwei=num/2;
        	ans.add(num%2);
        	p2--;
        }
        if(jinwei!=0)
        {
        	ans.add(1);
        }
        Collections.reverse(ans);
        StringBuffer res=new StringBuffer();
        for(int i=0;i<ans.size();i++)
        {
        	res.append(ans.get(i));
        }
        return res.toString();
    }
}
