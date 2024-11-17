import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int []ans=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
        	map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        Set<Integer> set=map.keySet();
        
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>()
        		{
        		public int compare(int p1[],int p2[])
        		{
        	return p2[1]-p1[1];
        		}
        		});
        for(int x:set)
        {
        	pq.offer(new int[] {x,map.get(x)});
        }
        
        int rank=1;
        while(rank<=k)
        {
        	ans[rank]=pq.peek()[0];
        	pq.poll();
        	rank++;
        }
        return ans;
    }
}







