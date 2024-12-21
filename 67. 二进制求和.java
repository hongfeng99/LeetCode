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
////////////更巧妙的写法
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        int n1 = a.length();
        int n2 = b.length();
        int n = Math.max(n1, n2);
        int i = 0;
        while (i < n) {
            carry += (i < n1) ? (a.charAt(n1 - 1 - i) - '0') : 0;
            carry += (i < n2) ? (b.charAt(n2 - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
            i++;
        }
        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
