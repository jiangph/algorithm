/**
 * Created by jiangph on 16-5-7.
 */
public class ProductExceptforSelf {

    public class Solution{

        public int[] productExceptSelf(int[]nums)
        {
            int[]ret=new int[nums.length];
            ret[nums.length-1]=1;
            //从右向左算一次
            for (int i=nums.length-1;i>=0;i--){
                ret[i]=ret[i+1]*nums[i+1];
            }
            //from the right to left by use of the ret
            int left=1;
            for (int i=0;i<nums.length-1;i++)
            {
                ret[i]*=left;
                left=nums[i]*left;
            }
            return ret;
        }

    }

}
