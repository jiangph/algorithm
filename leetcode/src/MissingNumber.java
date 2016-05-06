import java.util.Arrays;

/**
 * Created by jiangph on 16-5-6.
 */
public class MissingNumber {
    public class Solution{
        public int missingNumber(int[]nums)
        {
            //first,sort the array
            Arrays.sort(nums);
            int count=0;
            for (int i=0;i<nums.length;i++)
            {
                if (count==nums[i]) count++;
                else
                    count=i;
            }
            return count;
        }
    }
}
