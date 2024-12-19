import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
      //注意比较器的写法和格式///////////////////////
        Arrays.sort(intervals,new Comparator<int[]>()
        {
        	public int compare(int[]interval1,int[]interval2)
        	{
        		return interval1[0]-interval2[0];
        	}
        });
        List<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<n;i++)
        {
        	int L=res.get(res.size()-1)[0];
        	int R=res.get(res.size()-1)[1];
        	if(intervals[i][0]>R)
        	{
        		res.add(intervals[i]);
        	}
        	else
        	{
        		if(intervals[i][1]<=R)
        		{
        			continue;
        		}
        		else
        		{
        			res.remove(res.size()-1);
        			res.add(new int[] {L,intervals[i][1]});
        		}
        	}
        }
        int count=res.size();
        int[][]ans=new int[count][2];
        for(int i=0;i<count;i++)
        {
        	ans[i][0]=res.get(i)[0];
        	ans[i][1]=res.get(i)[1];
        }
        return ans;
    }
}
