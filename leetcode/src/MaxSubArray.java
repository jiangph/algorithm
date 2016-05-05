/**
 * Created by jiangph on 16-5-5.
 */
public class MaxSubArray {

    public class Solution{
        public int maxSubArray(int[]a)
        {
            /**
             * define two param,one restore the current max sum and the other restore the
             * sequence sum but when the restore <0, we should discard the max_sum_ending
             */
            int max_sum_ending=a[0];
            int max_sum=a[0];
            if (a.length<=0)
                return 0;
            for (int i=0;i<a.length;i++)
            {
                if (max_sum_ending<0)
                    max_sum_ending=a[i];
                else
                    max_sum_ending+=a[i];
                max_sum=Math.max(max_sum_ending,max_sum);
            }
            return max_sum;
        }
    }

}
