/**
 * Created by jiangph on 16-4-27.
 */
public class searchInsert {
    public class Solution{
        public int insertSearch(int[]A,int target)
        {
            int result=0;
            if (A.length<0) return 0;
            if (target<A[0]) return 0;
            for (int i=0;i<A.length;i++)
            {
                if (A[i]<target&&target<=A[i+1])
                {
                    result=i;
                }
            }
            return result;
        }
    }
}
