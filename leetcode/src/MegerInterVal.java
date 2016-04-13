/**
 * Created by jiangph on 16-4-13.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merger Intervals and Insert Interval合并间隔与插入间隔
 * 根据Interval的起点，我们将其排序，这样能合并的InterVal就一定是相邻的了
 *
 * 然后我们就顺序遍历这个列表，因为数组是有序的所以，在判断是否有重叠部分时，只要考虑带合并的interval的重点和遍历
 * 到的Interval的起点的关系就行了
 */
public class MegerInterVal {
    //define InterValue and its construct function
    class Interval{
        int start;
        int end;
        Interval()
        {
            start=0;
            end=0;
        }
        Interval(int s,int e){
            start=s;
            end=e;
        }
    }

    public class solution{
        public ArrayList<Interval>merge(ArrayList<Interval>intervals)
        {
            if (intervals==null&&intervals.size()<1)
            {
                return intervals;
            }
            ArrayList<Interval>result=new ArrayList<Interval>();
            //对ArrayList内的interval进行排序,重写comparator方法调用collection来实现
            Collections.sort(intervals,new IntervalComparator());
            //取出第一个Interval，我们开始排序
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

        //内部类,重写comparator方法
        class IntervalComparator implements Comparator<Interval>{

            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start-i2.start;
            }
        }
    }


}
