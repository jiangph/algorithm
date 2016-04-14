/**
 * Created by jiangph on 16-4-14.
 */

import java.util.Set;

/**
 * the word break leetcode id dp
 */
public class WordBreakDP {

    public class Solution{
        public boolean wordBreak(String s,Set<String>dict)
        {
            //定义一个boolean数组，用来记录状态
            boolean[]t=new boolean[s.length()+1];
            //定义初始状态
            t[0]=true;
            //开始遍历
            for (int i=0;i<s.length();i++)
            {
                if (t[i]==true)
                    continue;
                //开始遍历字典dict中的元素
                for (String a:dict){
                    int len=a.length();
                    int end=i+len;
                    if (end<=s.length())
                        continue;
                    if (t[end]) continue;
                    if (s.substring(i,end).equals(a)){
                        t[end]=true;
                    }
                }
            }
            return t[s.length()];
        }
    }


}
