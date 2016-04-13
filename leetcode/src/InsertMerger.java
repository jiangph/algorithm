/**
 * Created by jiangph on 16-4-14.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 插入间隔，与合并间隔类似，我们想某些序列插入一个数组，插入后的数组如果有重叠的部分就合并
 * 核心思想是先插入，在合并，关键点在与先插入时有一个查找的过程
 * 对于已经排好序的数组，我们可以使用二分查找来找到插入的位置
 *
 */
public class InsertMerger {

    class Interval{
        int start;
        int end;
        Interval(){
            start=0;
            end=0;
        }
        Interval(int s,int e){
            start=s;
            end=e;
        }
    }


    public class Solution{
        public List<Interval>insert(List<Interval>intervals,Interval newInterval)
        {
            if (newInterval==null)
                return intervals;
            //define a list to store the result
            List<Interval>result=new ArrayList<Interval>();
            //二分查找，找到newInterval的插入位置
            int l=0;
            int r=intervals.size()-1;
            while (l<=r){
                int mid=(l+r)>>1;
                if (intervals.get(mid).start>newInterval.start)
                {
                    r=mid-1;
                }
                else {
                    l=mid+1;
                }
            }
            intervals.add(l,newInterval);
            //经过二分查找，我们取到了合理的位置，之后开始进行插入,这里数组已经排好序
            Interval prev=intervals.get(0);
            for (int i=1;i<intervals.size();i++)
            {
                Interval curr=intervals.get(i);
                if (prev.end>=curr.start)
                {
                    Interval merged=new Interval(prev.start,curr.end);
                    prev=merged;
                }
                else {
                    result.add(prev);
                    prev=curr;
                }
            }
            //当ArrayList只有一个元素时，我们这里需要把第一个prev加上
            result.add(prev);
            return result;

        }

    }

}
