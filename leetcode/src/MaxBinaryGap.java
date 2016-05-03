/**
 * Created by jiangph on 16-5-3.
 */
public class MaxBinaryGap {

    public class Solution{
        public int MaxGap(int N)
        {
            int max=0;
            int count=1;
            int r=0;
            while (N>0)
            {
                r=N&1;
                N=N>>1;

                if (r==0&&count>=0)
                    count++;
                if (r==1)
                {
                    count=count>max?count:max;
                    count=0;
                }
            }
        return 0;
        }

    }

}
