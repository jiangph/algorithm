/**
 * Created by jiangph on 16-5-9.
 */
public class PlusAddOne {

    public class Solution{

        public int[] PlusAddOne(int[]digits)
        {
            int size=digits.length;
            int[]digitsOne=new int[size+1];
            if (digits[size-1]<9)
            {
                digits[size-1]+=1;
                return digits;
            }
            //need carry
            boolean carry=true;
            for (int i=size-1;i>=0;i++)
            {
                if (!carry)
                {
                    break;
                }
                if (digits[size-1]==9)
                {
                    carry=true;
                    //carry happen
                    digits[size-1]=0;
                    //the first number index
                    if (i==0)
                    {
                        digitsOne[0]=1;
                        digits[0]=0;
                        for (int j=1;j<digitsOne.length;j++)
                        {
                            digitsOne[j]=digits[j-1];
                        }
                    }
                    return digitsOne;
                }
            }

            return digits;
        }

    }

}
