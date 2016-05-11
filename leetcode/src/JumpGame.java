/**
 * Created by jiangph on 16-5-11.
 */
public class JumpGame {

    public class Solution{

        public boolean CanJump(int[]A,int n)
        {
            //n is the A's length
            int maxCover=0;
            for (int start=0;start<=maxCover&&start<n;start++)
            {
                if (A[start]+start>=maxCover)
                    maxCover=A[start]+start;
                if (maxCover>=n-1)
                    return true;
            }
            return false;
        }

    }


}
