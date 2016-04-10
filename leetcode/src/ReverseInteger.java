/**
 * Created by jiangph on 16-2-19.
 */
public class ReverseInteger {

    public int reverse(int x)
    {
        char[]IntegerArray=null;
        String numStr=" ";
        if (x==0)
            return x;
        else if (x>0)
        {
            numStr=x+" ";
            IntegerArray=numStr.toCharArray();
        }
        else
        {
            numStr=numStr+"-";

        }


        return x;
    }


}
