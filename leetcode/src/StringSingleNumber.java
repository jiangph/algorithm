/**
 * Created by jiangph on 16-4-22.
 */
public class StringSingleNumber {

    //使用位运算,统计每一位1的个数
    public class Solutin{

        public int StringNumber(int[]num)
        {
            int result=0;
            //tempNum用来存储结果
            int[]tempNum=new int[32];
            for (int i=0;i<32;i++)
            {
                for (int j=0;j<num.length;j++)
                {
                    tempNum[i]+=(num[j>>i])&1;
                }

            }
            //对每一位取余，没有出现三次的取3会为0
            for (int i=0;i<num.length;i++)
            {
                result+=(tempNum[i]%3)<<i;
            }
            return result;
        }

    }


}
