/**
 * Created by jiangph on 16-4-27.
 */
public class strStr {

    public class Solution{
        public int strStrBF(String hayStack,String needle)
        {
            int result=-1;
            if (needle.length()<hayStack.length())
                return -1;
            int i=0;
            while (i<hayStack.length())
            {
                int j=0;
                if (hayStack.charAt(i+j)==needle.charAt(j))
                {
                    j++;
                }
                if (j>needle.length())
                    return i;

            }
            return result;
        }
    }

}
