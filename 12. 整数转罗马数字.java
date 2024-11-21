import java.util.Map;

class Solution {
    public String intToRoman(int num) {
    	if(num>=4000)
    	{
    		return new String();
    	}
        Map<Integer,Character> map=new HashMap<Integer,Character>();
        StringBuffer ans=new StringBuffer();
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');
        int[] f=new int[] {1,5,10,50,100,500,1000};
        int ptr=6;
        while(num>0&&ptr>=0)
        {
        	if(num>=f[ptr])
        	{
        		String temp=Integer.toString(num); 
        		if(temp.charAt(0)=='9')
        		{
        			ans.append(map.get(f[ptr]));
        			ans.append(map.get(f[ptr+2]));
        			num=num+f[ptr]-f[ptr+2];
        		}
        		else if(temp.charAt(0)=='4')
        		{
        			ans.append(map.get(f[ptr]));
        			ans.append(map.get(f[ptr+1]));
        			num=num+f[ptr]-f[ptr+1];
        		}
        		else
        		{
        			while(ptr+1<7&&num-f[ptr+1]>=0)
        			{
        				num-=f[ptr+1];
        				ans.append(map.get(f[ptr+1]));
        			}
        			while(num-f[ptr]>=0)
        			{
        				num-=f[ptr];
        				ans.append(map.get(f[ptr]));
        			}
        		}
        		ptr-=2;
        	}
        	else
        	{
        		ptr-=2;
        	}
        
        }
        return ans.toString();
    }
}
/////////////////////////一种更快的方法，枚举


class Solution {
    public String intToRoman(int num) {
        StringBuilder a=new StringBuilder();        
            while(num>=1000)
            {
                a.append('M');
                num-=1000;
            }
            while(num>=900)
            {
                a.append("CM");
                num-=900;
            }        
             while(num>=500)
            {
                a.append('D');
                num-=500;
            }
            while(num>=400)
            {
                a.append("CD");
                num-=400;
            }            
             while(num>=100)
            {
                a.append('C');
                num-=100;
            }
            while(num>=90)
            {
                a.append("XC");
                num-=90;
            } 

             while(num>=50)
            {
                a.append('L');
                num-=50;
            }
             while(num>=40)
            {
                a.append("XL");
                num-=40;
            }
             while(num>=10)
            {
                a.append('X');
                num-=10;
            }
            while(num>=9)
            {
                a.append("IX");
                num-=9;
            }            
             while(num>=5)
            {
                a.append('V');
                num-=5;
            }
            while(num>=4)
            {
                a.append("IV");
                num-=4;
            }
            while(num>=1)
            {
                a.append('I');
                num-=1;
            }            
            return a.toString();
                                                                        
    }
}
