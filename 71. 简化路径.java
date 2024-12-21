import java.util.List;


class Solution {
    public String simplifyPath(String path) {
        int n=path.length();
        int ptr=0;
        List<String> ans=new ArrayList<String>();
        while(ptr<n)
        {
        	int begin=ptr;
        	while(ptr<n&&path.charAt(ptr)=='/')
        	{
        		ptr++;
        	}
        	if(ptr==begin+1)//如果仅有一个/
        	{
        		if(ptr==n&&ans.isEmpty()==true)
        		{
        			ans.add(new String("/"));
        		}
        		if(ptr!=n)
        		{
        			ans.add(new String("/"));	
        		}        		
        		if(ptr<n&&path.charAt(ptr)=='.')  //如果是/.
        		{
        			if(ptr==n-1)   //如果以/.结尾
        			{
        				if(ans.size()==1)
        				{
        					break;	
        				}
        				else
        				{
        					ans.remove(ans.size()-1);
        					break;
        				}
        			}
        			if(ptr+1<n&&path.charAt(ptr+1)=='.')   // 如果是  /..
        			{ 
        				if(ptr+2==n)  //      如果以/..结尾了
        				{
        					ptr+=2;
        					if(ans.size()>=3)
        					{
        						ans.remove(ans.size()-1);
        						ans.remove(ans.size()-1);
        						ans.remove(ans.size()-1);	
        						if(ans.size()==0)
        						{
        							ans.add(new String("/"));
        						}
        					}
        					else
        					{
        						break;
        					}
        				}
        				if(ptr+2<n)       
        				{ 
        					if(path.charAt(ptr+2)=='/')   //如果是 /../  
        					{
	        					ptr+=2;
	        					if(ans.size()>=3)         // 如果ans中已经包含 /name/
	        					{
	        						ans.remove(ans.size()-1);
	        						ans.remove(ans.size()-1);
	        						ans.remove(ans.size()-1);        						
	        					}
	        					if(ans.size()==1)   //假如ans中只剩下这一轮新增的/
	        					{
	        						ans.remove(ans.size()-1);
	        					}
        					}
        					else    //   如果是/...或者/..name
	        				{
	        					StringBuffer res=new StringBuffer();
	        					while(ptr<n&&path.charAt(ptr)!='/')
	        					{
	        						res.append(path.charAt(ptr));
	        						ptr++;
	        					}
	        					ans.add(res.toString());
	        				}
        				}
        			}
        			else    
        			{
        				if(path.charAt(ptr+1)=='/')   //如果是 /./
        				{
        					ans.remove(ans.size()-1);   //   移除/
            				ptr+=1;
            				continue;	
        				}
        				else               //如果是 /.name
        				{
        					StringBuffer res=new StringBuffer();
        					while(ptr<n&&path.charAt(ptr)!='/')
        					{
        						res.append(path.charAt(ptr));
        						ptr++;
        					}
        					ans.add(new String(res.toString()));
        				}
        			}
        		}
        		else                //  如果是 /name/
        		{
        			StringBuffer res=new StringBuffer();
        			while(ptr<n&&path.charAt(ptr)!='/')
        			{
        				res.append(path.charAt(ptr));
        				ptr++;
        			}
        			ans.add(res.toString());
        		}
        	}
        	else         //如果有连续两个及以上的/
        	{
        		if(ptr!=n)
        		{
        			ptr--;	
        		}
        		else
        		{
        			if(ans.isEmpty()==true)
        			{
        				ans.add(new String("/"));	
        			}        			
        		}
        	}
        }
        StringBuffer cur=new StringBuffer();
        for(int i=0;i<ans.size();i++)
        {
        	cur.append(ans.get(i));
        }
        return cur.toString();
    }
}
