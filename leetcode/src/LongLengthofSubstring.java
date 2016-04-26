/**
 * Created by jiangph on 16-4-26.
 */
public class LongLengthofSubstring {


    public class Solution{

        public int LongestSubstring(String a)
        {
            int result=0;
            if (a==null) return result;
            int countlength=1;
            int repeat=0;
            int maxLength=1;
            //从第一个位置开始遍历
            for (int i=1;i<a.length();i++)
            {
                repeat=a.substring(i-countlength,countlength).indexOf(a.charAt(i+1));
                //表示不重复
                if (repeat==-1)
                {
                    countlength++;
                }
                else
                {
                    //找到那个重复的元素
                    countlength-=repeat;
                }

                if (maxLength<countlength)
                {
                    maxLength=countlength;
                    result=maxLength;
                }
            }
            return result;
        }
    }


}
