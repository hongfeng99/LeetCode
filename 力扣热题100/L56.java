package 力扣热题100;

import java.util.Arrays;

public class L56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;               
        Arrays.sort(intervals,comparator);
        List<int[]> list=new ArrayList<int[]>();
        list.add(intervals[0]);
        for(int i=1;i<n;i++)
        {
        	int L=intervals[i][0];
        	int R=intervals[i][1];
        	if(list.get(list.size()-1)[1]<L)
        	{
        		list.add(new int[] {L,R});
        	}
        	else
        	{
        		list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],R);
        	}
        }
        return list.toArray(new int[merged.size()][]);
        
        

        
    }
    
    public void Comparator<int[]> comparator=(a,b)->Integer.compare(a[0],b[0]);
    
    public int[] merge(int a[],int b[])
    {
    	if(b[0]<=a[1]&&a[1]<=b[1])
    	{
    		return new int[] {a[0],b[1]};
    	}
    	
    	if(a[1]>=b[1])
    	{
    		return a;
    	}
    }
}











///////////////////////////
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==0)
        {
        	return new int[0][2];
        }
        List<int[]>list=new ArrayList<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
        	public int compare(int[]interval1,int[]interval2)
        	{
        		return interval1[0]-interval2[0];
        	}
        });
        list.add(intervals[0]);
        for(int i=1;i<n;i++)
        {
        	int left=intervals[i][0];
        	int right=intervals[i][1];
        	if(left>list.get(list.size()-1)[1])
        	{
        		list.add(intervals[i]);
        	}
        	else
        	{
        		list.get(list.size()-1)[1]=Math.max(right,list.get(list.size()-1)[1]);
        	}
        }
        return list.toArray(new int[list.size()][]);
    }
}







