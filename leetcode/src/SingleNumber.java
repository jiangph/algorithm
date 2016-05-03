/**
 * Created by jiangph on 16-5-3.
 */

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {
    public class Solution{
        public int SingleNumber(int[]array){
            /**
             * 关键是使用位运算
             */
            int x=0;
            for (int a:array)
            {
                x=x^a;
            }
            return x;
        }
    }
}
