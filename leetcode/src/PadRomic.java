/**
 * Created by jiangph on 16-4-30.
 */
public class PadRomic {

    public class Solution{

        public String LongestPadRomic(String s)
        {
            String longstr=null;
            if (s.length()==1) return s;
            int length=s.length();
            int maxlen=0;
            //define init matrix
            int[][]table =new int[length][length];
            for (int i=0;i<length;i++)
            {
                table[i][i]=1;
            }
            //two consecutive same letter are palindrome
            for (int i=0;i<length-2;i++)
            {
                if (s.charAt(i)==s.charAt(i+1))
                {
                    table[i][i+1]=1;
                    longstr=s.substring(i,i+1);
                }
            }
            //condition for calculate the whole table
            for (int l=3;l<=length;l++)
            {
                for (int i=0;i<length;i++)
                {
                    int j=l+i-1;
                    if (s.charAt(i)==s.charAt(j))
                    {
                        table[i][j]=table[i+1][j-1];
                        if (table[i][j]==1&&l>maxlen)
                        {
                            longstr=s.substring(i,j+1);
                            maxlen=longstr.length();
                        }
                        else
                        {
                            table[i][j]=0;
                        }
                    }
                }
            }
            return longstr;

        }


    }


}
