import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiangph on 16-4-28.
 */
public class TwoThreeSum {
    /**
     * K sum 是一类问题，三个数求和为0可以先固定一个数，求另外两个数相加为另一个数
     */
    public class Solution{
        //define a list to restore result
        List<List<Integer>>ret=new ArrayList<List<Integer>>();

        public List<List<Integer>> Find3Sum(int[]num,int target)
        {
            if (num==null||num.length<3) return null;
            //Array sort
            Arrays.sort(num);
            //remove duplicate script
            for (int i=0;i<num.length-2;i++)
            {
                if (num[i]==num[i+1]) continue;
                find(num,i,num.length,target);
            }
            return ret;
        }

        //First,We need to solve 2sum
        public void find(int[]num,int begin,int end,int target)
        {
            int l=begin;
            int r=end;
            while (l<r)
            {
                if (num[l]+num[r]+target==0)
                {
                    List<Integer>ans=new ArrayList<Integer>();
                    ans.add(num[l]);
                    ans.add(num[r]);
                    ans.add(target);
                    ret.add(ans);
                    while (l<r&&(num[l]==num[l+1])) l++;
                    while (l<r&&(num[r]==num[r-1])) r--;
                }
                else if (num[l]+num[r]+target<0) l++;
                else  r--;
            }
        }
    }

}
