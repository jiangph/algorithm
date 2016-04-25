/**
 * Created by jiangph on 16-4-25.
 */
public class RemoveDuplicateSortedArray {
    public class Solution{
        public int removeDuplicates(int[]array)
        {
            int result=0;
            int index=0;
            if (array.length<=0) return result;
            for (int i=0;i<array.length;i++)
            {
                if (array[i]!=array[i+1])
                {
                    index++;
                    array[index]=array[i];
                }
            }
            return result;
        }
    }
}
