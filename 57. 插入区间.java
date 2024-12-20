import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int L=newInterval[0];
        int R=newInterval[1];
        List<int[]>list=new ArrayList<>();
        int ptr=0;
        while(ptr<n&&intervals[ptr][1]<L)      //先把左边完全不相干的数组全添加进来
        {
        	list.add(intervals[ptr]);
        	ptr++;
        }
        while(ptr<n&&intervals[ptr][0]<=R)    //从第一个相干的数组起，直到后面第一个不相干的数组之前，融合
        {
        	L=Math.min(L, intervals[ptr][0]);
        	R=Math.max(R, intervals[ptr][1]);
        	ptr++;
        }
        list.add(new int[] {L,R});
        while(ptr<n)                          //从第一个不相干的数组开始，把余下的数组全部添加进去
        {
        	list.add(intervals[ptr]);
        	ptr++;
        }
        return list.toArray(new int[list.size()][2]); //注意list.toArray() 括号中间要添加数组格式的行数与列数
    }
}
